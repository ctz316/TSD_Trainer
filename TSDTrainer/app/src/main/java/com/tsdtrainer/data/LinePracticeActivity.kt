package com.tsdtrainer.app

import android.os.Bundle
import android.os.CountDownTimer
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.tsdtrainer.app.databinding.ActivityLinePracticeBinding
import com.tsdtrainer.app.models.MoveCombination
import com.tsdtrainer.app.models.PracticeType
import com.tsdtrainer.app.data.MovementRepository
import com.tsdtrainer.app.utils.FavoritesManager
import com.tsdtrainer.app.utils.PracticeHistoryService
import com.tsdtrainer.app.utils.SpacedRepetitionService
import com.tsdtrainer.app.utils.UserSettings

class LinePracticeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLinePracticeBinding

    // Timers
    private var sessionTimer: CountDownTimer? = null
    private var comboTimer: CountDownTimer? = null

    // Data
    private var allCombinations = mutableListOf<MoveCombination>()
    private var availableCombinations = mutableListOf<MoveCombination>()
    private var currentCombination: MoveCombination? = null

    // State
    // FIX #4/#5: currentBeltOnly starts true, auto-loads combinations on open
    private var currentBeltOnly = true
    private var favoritesOnly = false
    private var isRunning = false
    private var selectedMinutes = 5          // default session duration
    private var sessionStartTime = 0L
    private var practicedCount = 0

    // How many seconds each combination is shown before auto-advancing
    private val COMBO_SECONDS = 30L

    // Duration preset buttons mapped to minutes
    private val durationMap = mapOf(5 to 0, 10 to 1, 15 to 2, 20 to 3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLinePracticeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            title = "Line Practice"
            setDisplayHomeAsUpEnabled(true)
        }

        val belt = UserSettings.getBelt()
        allCombinations.addAll(MovementRepository.getMoveCombinations(belt))

        setupUI()

        // FIX #4: Apply default "Current Belt Only" before loading
        updateAvailableCombinations()

        // FIX #4: Show first combination immediately on open
        if (availableCombinations.isNotEmpty()) {
            nextCombination()
        }
    }

    private fun setupUI() {
        // FIX #4: Pre-check "Current Belt Only" in the UI to match the default state
        binding.cbCurrentBeltOnly.isChecked = true

        binding.cbCurrentBeltOnly.setOnCheckedChangeListener { _, isChecked ->
            currentBeltOnly = isChecked
            updateAvailableCombinations()
            if (availableCombinations.isNotEmpty()) nextCombination()
        }

        binding.cbFavoritesOnly.setOnCheckedChangeListener { _, isChecked ->
            favoritesOnly = isChecked
            updateAvailableCombinations()
            if (availableCombinations.isNotEmpty()) nextCombination()
        }

        // FIX #5/#6: Duration buttons — tapping starts/restarts the session countdown
        binding.btn5min.setOnClickListener  { toggleSession(5) }
        binding.btn10min.setOnClickListener { toggleSession(10) }
        binding.btn15min.setOnClickListener { toggleSession(15) }
        binding.btn20min.setOnClickListener { toggleSession(20) }

        // Favorite button is now the only action button
        binding.btnFavorite.setOnClickListener { toggleFavorite() }

        updateDurationButtonStates()
    }

    // Tap selected duration to stop; tap a duration to start/switch
    private fun toggleSession(minutes: Int) {
        if (isRunning && selectedMinutes == minutes) {
            stopSession()
        } else {
            selectedMinutes = minutes
            startSession()
        }
        updateDurationButtonStates()
    }

    private fun updateAvailableCombinations() {
        val belt = UserSettings.getBelt()
        availableCombinations = allCombinations.filter { combo ->
            val beltMatch = !currentBeltOnly || combo.belt == belt
            val favMatch  = !favoritesOnly  ||
                    FavoritesManager.isFavorite(PracticeType.LINE_PRACTICE, combo.moves.joinToString(" + "))
            beltMatch && favMatch
        }.toMutableList()

        if (availableCombinations.isEmpty()) {
            binding.tvCombination.text = when {
                favoritesOnly -> "No favorite combinations"
                currentBeltOnly -> "No combinations for current belt"
                else -> "No combinations available"
            }
        }
    }

    private fun nextCombination() {
        if (availableCombinations.isEmpty()) {
            updateAvailableCombinations()
            return
        }

        val comboKey: String? = SpacedRepetitionService.getNextItem(
            PracticeType.LINE_PRACTICE,
            availableCombinations.map { it.moves.joinToString(" + ") }
        )

        currentCombination = if (comboKey != null) {
            availableCombinations.find { it.moves.joinToString(" + ") == comboKey }
        } else {
            availableCombinations.random()
        }

        binding.tvCombination.text = currentCombination?.moves?.joinToString("\n") ?: ""
        practicedCount++
        updateFavoriteButton()
    }

    private fun startSession() {
        stopSession()
        if (availableCombinations.isEmpty()) return

        isRunning = true
        sessionStartTime = System.currentTimeMillis()
        practicedCount = 0

        nextCombination()
        startSessionCountdown()
        startComboCountdown()
    }

    // FIX #5: Visible session countdown (MM:SS format, prominent display)
    private fun startSessionCountdown() {
        val totalMs = selectedMinutes * 60 * 1000L
        sessionTimer = object : CountDownTimer(totalMs, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val s = millisUntilFinished / 1000
                binding.tvSessionTimer.text = String.format("%02d:%02d", s / 60, s % 60)
            }
            override fun onFinish() {
                binding.tvSessionTimer.text = "Done!"
                stopSession()
            }
        }.start()

        binding.tvSessionTimer.text = String.format("%02d:00", selectedMinutes)
        binding.tvSessionTimer.visibility = View.VISIBLE
    }

    // Each combination auto-advances after COMBO_SECONDS seconds
    private fun startComboCountdown() {
        comboTimer?.cancel()
        comboTimer = object : CountDownTimer(COMBO_SECONDS * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val s = (millisUntilFinished / 1000).toInt()
                binding.tvComboCountdown.text = "Next in ${s}s"
            }
            override fun onFinish() {
                if (isRunning) {
                    nextCombination()
                    startComboCountdown()
                }
            }
        }.start()
        binding.tvComboCountdown.visibility = View.VISIBLE
    }

    private fun stopSession() {
        isRunning = false
        sessionTimer?.cancel()
        comboTimer?.cancel()
        binding.tvSessionTimer.visibility = View.GONE
        binding.tvComboCountdown.visibility = View.GONE
        saveSession()
        updateDurationButtonStates()
    }

    private fun toggleFavorite() {
        currentCombination?.let { combo ->
            val key = combo.moves.joinToString(" + ")
            FavoritesManager.toggleFavorite(PracticeType.LINE_PRACTICE, key)
            updateFavoriteButton()

            if (favoritesOnly) {
                updateAvailableCombinations()
                if (availableCombinations.isNotEmpty()) nextCombination()
            }
        }
    }

    private fun updateFavoriteButton() {
        currentCombination?.let { combo ->
            val key = combo.moves.joinToString(" + ")
            val isFavorite = FavoritesManager.isFavorite(PracticeType.LINE_PRACTICE, key)
            binding.btnFavorite.text = if (isFavorite) "⭐ Favorited" else "☆ Favorite"
            binding.btnFavorite.backgroundTintList = android.content.res.ColorStateList.valueOf(
                if (isFavorite) android.graphics.Color.parseColor("#DC143C")
                else android.graphics.Color.parseColor("#2A2A2A")
            )
        }
    }

    // Highlight the active duration button in red; others dimmed
    private fun updateDurationButtonStates() {
        val buttons = listOf(
            Pair(binding.btn5min, 5),
            Pair(binding.btn10min, 10),
            Pair(binding.btn15min, 15),
            Pair(binding.btn20min, 20)
        )
        buttons.forEach { (btn, min) ->
            val isActive = isRunning && selectedMinutes == min
            btn.backgroundTintList = android.content.res.ColorStateList.valueOf(
                if (isActive) android.graphics.Color.parseColor("#DC143C")
                else android.graphics.Color.parseColor("#2A2A2A")
            )
        }
    }

    private fun saveSession() {
        if (sessionStartTime > 0 && practicedCount > 0) {
            val duration = ((System.currentTimeMillis() - sessionStartTime) / 60000).toInt()
            if (duration > 0) {
                PracticeHistoryService.addSession(PracticeType.LINE_PRACTICE, practicedCount, duration)
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
        sessionTimer?.cancel()
        comboTimer?.cancel()
        saveSession()
    }
}