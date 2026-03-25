package com.tsdtrainer.app.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Represents a combination of movements for line practice
 * Each combination consists of 2-4 movements performed in sequence
 */
@Parcelize
data class MoveCombination(
    val belt: Belt,
    val moves: List<String>,
    val category: String = "Mixed" // Could be "Kicks", "Blocks", "Mixed", etc.
) : Parcelable