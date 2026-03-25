package com.tsdtrainer.app

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.tsdtrainer.app.databinding.ActivityMainBinding
import com.tsdtrainer.app.models.Belt
import com.tsdtrainer.app.utils.UserSettings
import com.tsdtrainer.data.KoreanTermsActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "TSD Trainer"
        updateBeltDisplay()
        setupButtons()
    }

    override fun onResume() {
        super.onResume()
        updateBeltDisplay()
    }

    private fun updateBeltDisplay() {
        val belt = UserSettings.getBelt()
        binding.tvBeltName.text = "${belt.toDisplayName()} — Rank ${belt.rank}"
        binding.tvBeltName.setTextColor(
            if (belt == Belt.WHITE) getColor(android.R.color.white)
            else getColor(android.R.color.black)
        )
        binding.tvMotivation.text = getMotivationalQuote(belt)

        // Tint the belt card to the user's belt color
        val beltColor = when (belt) {
            Belt.WHITE, Belt.SENIOR_WHITE -> android.graphics.Color.parseColor("#DDDDDD")
            Belt.ORANGE, Belt.SENIOR_ORANGE -> android.graphics.Color.parseColor("#E87722")
            Belt.GREEN, Belt.SENIOR_GREEN -> android.graphics.Color.parseColor("#2E8B57")
            Belt.BROWN, Belt.SENIOR_BROWN -> android.graphics.Color.parseColor("#6B3A2A")
            Belt.RED, Belt.SENIOR_RED -> android.graphics.Color.parseColor("#DC143C")
            Belt.BLUE -> android.graphics.Color.parseColor("#1E6FBF")
            Belt.BLACK -> android.graphics.Color.parseColor("#1A1A1A")
        }
        binding.beltFrame.setCardBackgroundColor(beltColor)
    }

    private fun getMotivationalQuote(belt: Belt) = when (belt) {
        Belt.WHITE        -> "Begin your journey with discipline and focus"
        Belt.SENIOR_WHITE -> "Growing stronger every day"
        Belt.ORANGE       -> "Energy builds momentum"
        Belt.SENIOR_ORANGE-> "Your dedication shows progress"
        Belt.GREEN        -> "Growth through persistent practice"
        Belt.SENIOR_GREEN -> "Your skills are developing well"
        Belt.BROWN        -> "Experience comes from challenges overcome"
        Belt.SENIOR_BROWN -> "Excellence is within reach"
        Belt.RED          -> "Danger to those who oppose righteousness"
        Belt.SENIOR_RED   -> "Approaching mastery"
        Belt.BLUE         -> "The sky is the limit"
        Belt.BLACK        -> "The master is the eternal student"
    }

    private fun setupButtons() {
        binding.btnMovementPractice.setOnClickListener {
            startActivity(Intent(this, MovementPracticeActivity::class.java))
        }
        binding.btnLinePractice.setOnClickListener {
            startActivity(Intent(this, LinePracticeActivity::class.java))
        }
        binding.btnKnowledgePractice.setOnClickListener {
            startActivity(Intent(this, KnowledgePracticeActivity::class.java))
        }
        // FIX #1: Launch the real quiz instead of showing a Toast
        binding.btnKnowledgeQuiz.setOnClickListener {
            startActivity(Intent(this, KnowledgeQuizActivity::class.java))
        }
        binding.btnKoreanTerms.setOnClickListener {
            startActivity(Intent(this, KoreanTermsActivity::class.java))
        }
        binding.btnEssayRequirements.setOnClickListener {
            startActivity(Intent(this, EssayRequirementsActivity::class.java))
        }
        binding.btnHistory.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                startActivity(Intent(this, SettingsActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}