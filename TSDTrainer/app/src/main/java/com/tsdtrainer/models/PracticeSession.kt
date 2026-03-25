package com.tsdtrainer.app.models

import java.util.Date

enum class PracticeType {
    MOVEMENT_PRACTICE,
    LINE_PRACTICE,
    KNOWLEDGE_PRACTICE,
    KNOWLEDGE_QUIZ,
    KOREAN_TERMS
}

data class PracticeSession(
    val type: PracticeType,
    val itemCount: Int,
    val durationMinutes: Int,
    val sessionDate: Date
)