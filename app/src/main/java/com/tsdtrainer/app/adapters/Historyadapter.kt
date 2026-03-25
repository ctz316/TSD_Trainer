package com.tsdtrainer.app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tsdtrainer.app.databinding.ItemHistoryBinding
import com.tsdtrainer.app.models.PracticeSession
import java.text.SimpleDateFormat
import java.util.*

class HistoryAdapter : ListAdapter<PracticeSession, HistoryAdapter.HistoryViewHolder>(HistoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = ItemHistoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class HistoryViewHolder(
        private val binding: ItemHistoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val dateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
        private val timeFormat = SimpleDateFormat("h:mm a", Locale.getDefault())

        fun bind(session: PracticeSession) {
            // Format the practice type name
            binding.tvPracticeType.text = when (session.type) {
                com.tsdtrainer.app.models.PracticeType.MOVEMENT_PRACTICE -> "Movement Practice"
                com.tsdtrainer.app.models.PracticeType.LINE_PRACTICE -> "Line Practice"
                com.tsdtrainer.app.models.PracticeType.KNOWLEDGE_PRACTICE -> "Knowledge Practice"
                com.tsdtrainer.app.models.PracticeType.KNOWLEDGE_QUIZ -> "Knowledge Quiz"
                com.tsdtrainer.app.models.PracticeType.KOREAN_TERMS -> "Korean Terms"
            }

            // Display date and time
            binding.tvDate.text = dateFormat.format(session.sessionDate)
            binding.tvTime.text = timeFormat.format(session.sessionDate)

            // Display session stats
            binding.tvItemCount.text = "${session.itemCount} items"
            binding.tvDuration.text = "${session.durationMinutes} min"
        }
    }

    class HistoryDiffCallback : DiffUtil.ItemCallback<PracticeSession>() {
        override fun areItemsTheSame(oldItem: PracticeSession, newItem: PracticeSession): Boolean {
            return oldItem.sessionDate == newItem.sessionDate && oldItem.type == newItem.type
        }

        override fun areContentsTheSame(oldItem: PracticeSession, newItem: PracticeSession): Boolean {
            return oldItem == newItem
        }
    }
}