package com.tsdtrainer.data

import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView
import com.tsdtrainer.app.databinding.ActivityKoreanTermsBinding
import com.tsdtrainer.app.data.KoreanTermRepository
import com.tsdtrainer.app.models.KoreanTerm
import com.tsdtrainer.app.models.PracticeType
import com.tsdtrainer.app.utils.PracticeHistoryService
import com.tsdtrainer.app.utils.UserSettings

class KoreanTermsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKoreanTermsBinding

    private var allTerms = listOf<KoreanTerm>()
    private var currentTerm: KoreanTerm? = null
    private var answered = false

    private var score = 0
    private var totalAnswered = 0
    private var streak = 0

    private lateinit var answerCards: List<MaterialCardView>
    private lateinit var answerTextViews: List<TextView>
    private var currentChoices = listOf<String>()

    private var sessionStartTime = 0L
    private var practicedCount = 0

    // Colors — blue theme for Korean Terms
    private val colorBg             = Color.parseColor("#1A1A1A")
    private val colorCorrect        = Color.parseColor("#228B22")
    private val colorWrong          = Color.parseColor("#CC0000")
    private val colorStrokeDefault  = Color.parseColor("#444444")
    private val colorStrokeCorrect  = Color.parseColor("#228B22")
    private val colorStrokeWrong    = Color.parseColor("#CC0000")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKoreanTermsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            title = "Korean Terms"
            setDisplayHomeAsUpEnabled(true)
        }

        val belt = UserSettings.getBelt()
        allTerms = KoreanTermRepository.getForBeltAndBelow(belt)

        if (allTerms.size < 4) {
            binding.tvKoreanQuestion.text = "Not enough terms for your belt level yet."
            binding.tvKoreanCategory.visibility = View.GONE
            binding.btnKoreanNext.visibility = View.GONE
            return
        }

        answerCards = listOf(
            binding.cardKoreanAnswer1,
            binding.cardKoreanAnswer2,
            binding.cardKoreanAnswer3,
            binding.cardKoreanAnswer4
        )
        answerTextViews = listOf(
            binding.tvKoreanAnswer1,
            binding.tvKoreanAnswer2,
            binding.tvKoreanAnswer3,
            binding.tvKoreanAnswer4
        )

        sessionStartTime = System.currentTimeMillis()

        binding.btnKoreanNext.setOnClickListener { nextTerm() }
        nextTerm()
    }

    private fun nextTerm() {
        answered = false
        binding.tvKoreanFeedback.visibility = View.GONE
        binding.btnKoreanNext.visibility = View.GONE
        binding.tvKoreanFeedback.text = ""

        answerCards.forEachIndexed { i, card ->
            card.setCardBackgroundColor(colorBg)
            card.strokeColor = colorStrokeDefault
            card.isClickable = true
            card.isFocusable = true
            answerTextViews[i].text = ""
        }

        // Pick a new term different from current if possible
        val pool = if (allTerms.size > 1) allTerms.filter { it != currentTerm } else allTerms
        currentTerm = pool.random()
        val term = currentTerm ?: return

        // Build 4 choices: correct Korean + 3 wrong Korean terms
        val wrongAnswers = allTerms
            .filter { it != term }
            .shuffled()
            .take(3)
            .map { it.korean }

        currentChoices = (wrongAnswers + term.korean).shuffled()

        totalAnswered++
        practicedCount++
        binding.tvKoreanQuestion.text = term.english
        binding.tvKoreanCategory.text = term.category
        updateScoreDisplay()

        currentChoices.forEachIndexed { i, korean ->
            answerTextViews[i].text = korean
            answerCards[i].setOnClickListener {
                onAnswerTapped(i, korean, term.korean)
            }
        }
    }

    private fun onAnswerTapped(tappedIndex: Int, selected: String, correct: String) {
        if (answered) return
        answered = true

        answerCards.forEach { card ->
            card.isClickable = false
            card.isFocusable = false
        }

        val isCorrect = selected == correct

        if (isCorrect) {
            score++
            streak++
            answerCards[tappedIndex].setCardBackgroundColor(colorCorrect)
            answerCards[tappedIndex].strokeColor = colorStrokeCorrect
            binding.tvKoreanFeedback.text = "✅ Correct!"
            binding.tvKoreanFeedback.setTextColor(colorCorrect)
        } else {
            streak = 0
            answerCards[tappedIndex].setCardBackgroundColor(colorWrong)
            answerCards[tappedIndex].strokeColor = colorStrokeWrong
            binding.tvKoreanFeedback.text = "❌  Incorrect"
            binding.tvKoreanFeedback.setTextColor(colorWrong)
            val correctIndex = currentChoices.indexOf(correct)
            if (correctIndex >= 0) {
                answerCards[correctIndex].setCardBackgroundColor(colorCorrect)
                answerCards[correctIndex].strokeColor = colorStrokeCorrect
            }
        }

        updateScoreDisplay()
        binding.tvKoreanFeedback.visibility = View.VISIBLE
        binding.btnKoreanNext.visibility = View.VISIBLE
    }

    private fun updateScoreDisplay() {
        val streakIcon = if (streak >= 3) " 🔥" else ""
        binding.tvKoreanScore.text = "Score: $score / $totalAnswered  |  Streak: $streak$streakIcon"
    }

    private fun saveSession() {
        if (sessionStartTime > 0 && practicedCount > 0) {
            val duration = ((System.currentTimeMillis() - sessionStartTime) / 60000).toInt()
            if (duration > 0) {
                PracticeHistoryService.addSession(
                    PracticeType.KOREAN_TERMS,
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
            android.R.id.home -> { finish(); true }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        saveSession()
    }
}
