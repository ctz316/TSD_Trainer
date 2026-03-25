package com.tsdtrainer.app

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.tsdtrainer.app.databinding.ActivityKnowledgePracticeBinding
import com.tsdtrainer.app.models.KnowledgeItem
import com.tsdtrainer.app.models.PracticeType
import com.tsdtrainer.app.data.KnowledgeRepository
import com.tsdtrainer.app.utils.PracticeHistoryService
import com.tsdtrainer.app.utils.SpacedRepetitionService
import com.tsdtrainer.app.utils.UserSettings

class KnowledgePracticeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKnowledgePracticeBinding

    private var allQuestions = mutableListOf<KnowledgeItem>()
    private var availableQuestions = mutableListOf<KnowledgeItem>()
    private var currentQuestion: KnowledgeItem? = null
    private var previousQuestions = mutableListOf<KnowledgeItem>()

    private var sessionStartTime = 0L
    private var practicedCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKnowledgePracticeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            title = "Knowledge Practice"
            setDisplayHomeAsUpEnabled(true)
        }

        val belt = UserSettings.getBelt()
        allQuestions.addAll(KnowledgeRepository.getForCurrentBeltGroup(belt))
        availableQuestions.addAll(allQuestions)

        sessionStartTime = System.currentTimeMillis()

        setupUI()
        nextQuestion()
    }

    private fun setupUI() {
        binding.btnNext.setOnClickListener {
            nextQuestion()
        }

        binding.btnPrevious.setOnClickListener {
            previousQuestion()
        }
    }

    private fun nextQuestion() {
        if (availableQuestions.isEmpty()) {
            binding.tvQuestion.text = "No questions available for your belt level"
            binding.tvAnswer.text = ""
            binding.btnNext.isEnabled = false
            return
        }

        // Save current question to history if exists
        currentQuestion?.let { previousQuestions.add(it) }

        // Use spaced repetition to select next question
        val selectedQuestion: String? = SpacedRepetitionService.getNextItem(
            PracticeType.KNOWLEDGE_PRACTICE,
            availableQuestions.map { it.question }
        )

        currentQuestion = if (selectedQuestion != null) {
            availableQuestions.find { it.question == selectedQuestion }
        } else {
            availableQuestions.random()
        }

        binding.tvQuestion.text = currentQuestion?.question ?: ""
        binding.tvAnswer.text = currentQuestion?.answer ?: ""
        practicedCount++

        // Enable/disable previous button
        binding.btnPrevious.isEnabled = previousQuestions.isNotEmpty()
    }

    private fun previousQuestion() {
        if (previousQuestions.isEmpty()) return

        // Get the last question from history
        currentQuestion = previousQuestions.removeAt(previousQuestions.size - 1)

        binding.tvQuestion.text = currentQuestion?.question ?: ""
        binding.tvAnswer.text = currentQuestion?.answer ?: ""

        // Disable previous button if no more history
        binding.btnPrevious.isEnabled = previousQuestions.isNotEmpty()
    }

    private fun saveSession() {
        if (sessionStartTime > 0 && practicedCount > 0) {
            val duration = ((System.currentTimeMillis() - sessionStartTime) / 60000).toInt()
            if (duration > 0) {
                PracticeHistoryService.addSession(
                    PracticeType.KNOWLEDGE_PRACTICE,
                    practicedCount,
                    duration
                )
            }
        }
        sessionStartTime = 0
        practicedCount = 0
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        saveSession()
    }
}