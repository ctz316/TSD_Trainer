package com.tsdtrainer.app

import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.tsdtrainer.app.databinding.ActivitySettingsBinding
import com.tsdtrainer.app.models.Belt
import com.tsdtrainer.app.utils.UserSettings

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            title = "Settings"
            setDisplayHomeAsUpEnabled(true)
        }

        setupBeltSpinner()
        setupSaveButton()
    }

    private fun setupBeltSpinner() {
        val belts = Belt.values().map { it.toDisplayName() }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, belts)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerBelt.adapter = adapter

        val currentBelt = UserSettings.getBelt()
        val position = Belt.values().indexOf(currentBelt)
        binding.spinnerBelt.setSelection(position)
    }

    private fun setupSaveButton() {
        binding.btnSave.setOnClickListener {
            val selectedPosition = binding.spinnerBelt.selectedItemPosition
            val selectedBelt = Belt.values()[selectedPosition]
            UserSettings.setBelt(selectedBelt)
            finish()
        }
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
}