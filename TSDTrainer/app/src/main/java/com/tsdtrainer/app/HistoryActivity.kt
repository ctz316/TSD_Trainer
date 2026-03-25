package com.tsdtrainer.app

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tsdtrainer.app.adapters.HistoryAdapter
import com.tsdtrainer.app.databinding.ActivityHistoryBinding
import com.tsdtrainer.app.utils.PracticeHistoryService

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding
    private lateinit var adapter: HistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            title = "Practice History"
            setDisplayHomeAsUpEnabled(true)
        }

        setupRecyclerView()
        loadHistory()
    }

    private fun setupRecyclerView() {
        adapter = HistoryAdapter()
        binding.rvHistory.layoutManager = LinearLayoutManager(this)
        binding.rvHistory.adapter = adapter
    }

    private fun loadHistory() {
        val sessions = PracticeHistoryService.getRecentSessions()
        adapter.submitList(sessions)
        // Show empty state when no history exists
        binding.tvEmpty.visibility = if (sessions.isEmpty()) android.view.View.VISIBLE else android.view.View.GONE
        binding.rvHistory.visibility = if (sessions.isEmpty()) android.view.View.GONE else android.view.View.VISIBLE
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