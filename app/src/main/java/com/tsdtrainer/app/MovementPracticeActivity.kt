package com.tsdtrainer.app

import android.os.Bundle
import android.os.CountDownTimer
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.tsdtrainer.app.databinding.ActivityMovementPracticeBinding
import com.tsdtrainer.app.data.MovementRepository
import com.tsdtrainer.app.models.Movement
import com.tsdtrainer.app.models.MovementCategory
import com.tsdtrainer.app.models.MovementSide
import com.tsdtrainer.app.models.PracticeType
import com.tsdtrainer.app.utils.PracticeHistoryService
import com.tsdtrainer.app.utils.SpacedRepetitionService
import com.tsdtrainer.app.utils.UserSettings

class MovementPracticeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovementPracticeBinding

    // Timers
    private var autoNextTimer: CountDownTimer? = null
    private var sessionTimer: CountDownTimer? = null

    // Data
    private var selectedCategories = mutableSetOf<MovementCategory>()
    private var allMovements = mutableListOf<Movement>()
    private var availableMovements = mutableListOf<Movement>()
    private var currentMovement: Movement? = null

    // Session tracking
    private var sessionStartTime = 0L
    private var practicedCount = 0
    private var selectedSessionMinutes = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovementPracticeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            title = "Movement Practice"
            setDisplayHomeAsUpEnabled(true)
        }

        val belt = UserSettings.getBelt()
        allMovements.addAll(MovementRepository.getForBeltAndBelow(belt))

        setupUI()
        updateCategories()
    }

    private fun setupUI() {
        // Category checkboxes
        binding.cbHands.setOnCheckedChangeListener { _, _ -> updateCategories() }
        binding.cbFeet.setOnCheckedChangeListener { _, _ -> updateCategories() }
        binding.cbDefense.setOnCheckedChangeListener { _, _ -> updateCategories() }
        binding.cbForms.setOnCheckedChangeListener { _, _ -> updateCategories() }

        // Auto Next Switch
        binding.switchAutoNext.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked && currentMovement != null) {
                startAutoNextTimer()
            } else {
                stopAutoNextTimer()
            }
        }

        // Session Timer Spinner
        val timerOptions = arrayOf("5 min", "10 min", "15 min", "20 min", "30 min", "Off")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, timerOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerTimer.adapter = adapter
        binding.spinnerTimer.setSelection(1) // Default to 10 min

        binding.spinnerTimer.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedSessionMinutes = when (position) {
                    0 -> 5; 1 -> 10; 2 -> 15; 3 -> 20; 4 -> 30; else -> 0
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Session Timer Switch
        binding.switchSessionTimer.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked && selectedSessionMinutes > 0) {
                startSessionTimer()
            } else {
                stopSessionTimer()
            }
        }

        // Pause Session Button
        binding.btnPauseSession.setOnClickListener {
            sessionTimer?.cancel()
            binding.btnPauseSession.visibility = View.GONE
            binding.switchSessionTimer.isChecked = false
        }

        // Next Movement Button
        binding.btnNext.setOnClickListener {
            nextMovement()
        }
    }

    private fun updateCategories() {
        selectedCategories.clear()
        if (binding.cbHands.isChecked)   selectedCategories.add(MovementCategory.HANDS)
        if (binding.cbFeet.isChecked)    selectedCategories.add(MovementCategory.FEET)
        if (binding.cbDefense.isChecked) selectedCategories.add(MovementCategory.DEFENSE)
        if (binding.cbForms.isChecked)   selectedCategories.add(MovementCategory.FORMS)

        updateAvailableMovements()

        if (availableMovements.isNotEmpty()) {
            nextMovement()
        }
    }

    private fun updateAvailableMovements() {
        availableMovements = allMovements.filter { movement ->
            selectedCategories.isEmpty() || selectedCategories.contains(movement.category)
        }.toMutableList()

        if (availableMovements.isEmpty()) {
            binding.tvCurrentMovement.text = when {
                selectedCategories.isEmpty() -> "Select categories above"
                else -> "No movements match your filters"
            }
            // FIX #3: Clear side label when nothing is showing
            binding.tvSideLabel.text = ""
            binding.tvSideLabel.visibility = View.GONE
        }
    }

    private fun nextMovement() {
        if (availableMovements.isEmpty()) {
            updateAvailableMovements()
            return
        }

        currentMovement = SpacedRepetitionService.getNextItem(
            PracticeType.MOVEMENT_PRACTICE,
            availableMovements.map { it.name }
        )?.let { name ->
            availableMovements.find { it.name == name }
        } ?: availableMovements.random()

        displayCurrentMovement()
        practicedCount++

        if (binding.switchAutoNext.isChecked) {
            startAutoNextTimer()
        }
    }

    // FIX #3: Show movement name AND the Regular/Opposite side label separately
    private fun displayCurrentMovement() {
        val movement = currentMovement ?: return
        binding.tvCurrentMovement.text = movement.name

        if (movement.category == MovementCategory.FORMS) {
            // Forms have no "side" concept
            binding.tvSideLabel.visibility = View.GONE
            binding.tvSideLabel.text = ""
        } else {
            val sideText = when (movement.side) {
                MovementSide.REGULAR  -> "Regular Side"
                MovementSide.OPPOSITE -> "Opposite Side"
                MovementSide.NONE     -> ""
            }
            if (sideText.isNotEmpty()) {
                binding.tvSideLabel.text = sideText
                binding.tvSideLabel.visibility = View.VISIBLE
            } else {
                binding.tvSideLabel.visibility = View.GONE
            }
        }
    }

    private fun startAutoNextTimer() {
        stopAutoNextTimer()
        binding.tvAutoNextTimer.visibility = View.VISIBLE

        autoNextTimer = object : CountDownTimer(25000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = (millisUntilFinished / 1000).toInt()
                binding.tvAutoNextTimer.text = "${secondsRemaining}s"
            }
            override fun onFinish() { nextMovement() }
        }.start()
    }

    private fun stopAutoNextTimer() {
        autoNextTimer?.cancel()
        binding.tvAutoNextTimer.visibility = View.GONE
    }

    private fun startSessionTimer() {
        stopSessionTimer()
        if (selectedSessionMinutes <= 0) return

        sessionStartTime = System.currentTimeMillis()
        practicedCount = 0

        binding.tvSessionTimer.visibility = View.VISIBLE
        binding.btnPauseSession.visibility = View.VISIBLE
        binding.spinnerTimer.isEnabled = false

        val totalSeconds = selectedSessionMinutes * 60
        sessionTimer = object : CountDownTimer((totalSeconds * 1000).toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val s = millisUntilFinished / 1000
                binding.tvSessionTimer.text = String.format("%02d:%02d", s / 60, s % 60)
            }
            override fun onFinish() {
                binding.tvSessionTimer.text = "00:00"
                stopSessionTimer()
                saveSession()
                binding.switchSessionTimer.isChecked = false
            }
        }.start()
    }

    private fun stopSessionTimer() {
        sessionTimer?.cancel()
        binding.tvSessionTimer.visibility = View.GONE
        binding.btnPauseSession.visibility = View.GONE
        binding.spinnerTimer.isEnabled = true
    }

    private fun saveSession() {
        if (sessionStartTime > 0 && practicedCount > 0) {
            val duration = ((System.currentTimeMillis() - sessionStartTime) / 60000).toInt()
            if (duration > 0) {
                PracticeHistoryService.addSession(PracticeType.MOVEMENT_PRACTICE, practicedCount, duration)
            }
        }
        sessionStartTime = 0
        practicedCount = 0
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> { finish(); true }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopAutoNextTimer()
        stopSessionTimer()
        saveSession()
    }
}