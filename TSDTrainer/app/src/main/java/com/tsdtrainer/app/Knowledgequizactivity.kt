package com.tsdtrainer.app

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView
import com.tsdtrainer.app.databinding.ActivityKnowledgeQuizBinding
import com.tsdtrainer.app.data.KnowledgeRepository
import com.tsdtrainer.app.models.KnowledgeItem
import com.tsdtrainer.app.utils.UserSettings

class KnowledgeQuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKnowledgeQuizBinding

    private var allQuestions = listOf<KnowledgeItem>()
    private var currentQuestion: KnowledgeItem? = null
    private var answered = false

    private var score = 0
    private var totalAnswered = 0
    private var streak = 0

    private lateinit var answerCards: List<MaterialCardView>
    private lateinit var answerTextViews: List<TextView>
    private var currentChoices = listOf<String>()

    // Colors
    private val colorBg        = Color.parseColor("#1A1A1A")
    private val colorCorrect   = Color.parseColor("#228B22")
    private val colorWrong     = Color.parseColor("#CC0000")
    private val colorStrokeDefault = Color.parseColor("#444444")
    private val colorStrokeCorrect = Color.parseColor("#228B22")
    private val colorStrokeWrong   = Color.parseColor("#CC0000")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKnowledgeQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            title = "Knowledge Quiz"
            setDisplayHomeAsUpEnabled(true)
        }

        val belt = UserSettings.getBelt()
        allQuestions = KnowledgeRepository.getForBeltAndBelow(belt)
            .filter { it.answer.length < 150 }

        if (allQuestions.size < 4) {
            binding.tvQuizQuestion.text = "Not enough questions for your belt level yet."
            binding.btnNextQuestion.visibility = View.GONE
            return
        }

        answerCards = listOf(
            binding.cardAnswer1,
            binding.cardAnswer2,
            binding.cardAnswer3,
            binding.cardAnswer4
        )
        answerTextViews = listOf(
            binding.tvAnswer1,
            binding.tvAnswer2,
            binding.tvAnswer3,
            binding.tvAnswer4
        )

        binding.btnNextQuestion.setOnClickListener { nextQuestion() }
        nextQuestion()
    }

    private fun nextQuestion() {
        answered = false
        binding.tvFeedback.visibility = View.GONE
        binding.btnNextQuestion.visibility = View.GONE
        binding.tvFeedback.text = ""

        answerCards.forEachIndexed { i, card ->
            card.setCardBackgroundColor(colorBg)
            card.strokeColor = colorStrokeDefault
            card.isClickable = true
            card.isFocusable = true
            answerTextViews[i].text = ""
        }

        val pool = if (allQuestions.size > 1) allQuestions.filter { it != currentQuestion } else allQuestions
        currentQuestion = pool.random()
        val question = currentQuestion ?: return

        val wrongAnswers = allQuestions
            .filter { it != question }
            .shuffled()
            .take(3)
            .map { it.answer }

        currentChoices = (wrongAnswers + question.answer).shuffled()

        totalAnswered++
        binding.tvQuizQuestion.text = question.question
        updateScoreDisplay()

        currentChoices.forEachIndexed { i, answer ->
            answerTextViews[i].text = answer
            answerCards[i].setOnClickListener {
                onAnswerTapped(i, answer, question.answer)
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
            binding.tvFeedback.text = "✅ Correct!"
            binding.tvFeedback.setTextColor(colorCorrect)
        } else {
            streak = 0
            answerCards[tappedIndex].setCardBackgroundColor(colorWrong)
            answerCards[tappedIndex].strokeColor = colorStrokeWrong
            binding.tvFeedback.text = "❌ Incorrect"
            binding.tvFeedback.setTextColor(colorWrong)
            val correctIndex = currentChoices.indexOf(correct)
            if (correctIndex >= 0) {
                answerCards[correctIndex].setCardBackgroundColor(colorCorrect)
                answerCards[correctIndex].strokeColor = colorStrokeCorrect
            }
        }

        updateScoreDisplay()
        binding.tvFeedback.visibility = View.VISIBLE
        binding.btnNextQuestion.visibility = View.VISIBLE
    }

    private fun updateScoreDisplay() {
        val streakIcon = if (streak >= 3) " 🔥" else ""
        binding.tvScore.text = "Score: $score / $totalAnswered  |  Streak: $streak$streakIcon"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> { finish(); true }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
