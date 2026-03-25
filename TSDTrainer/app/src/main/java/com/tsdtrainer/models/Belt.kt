package com.tsdtrainer.app.models

import android.os.Parcelable
import com.tsdtrainer.app.R
import kotlinx.parcelize.Parcelize

@Parcelize
enum class Belt : Parcelable {
    WHITE,
    SENIOR_WHITE,
    ORANGE,
    SENIOR_ORANGE,
    GREEN,
    SENIOR_GREEN,
    BROWN,
    SENIOR_BROWN,
    RED,
    SENIOR_RED,
    BLUE,
    BLACK;

    val rank: Int
        get() = this.ordinal

    val isSenior: Boolean
        get() = when (this) {
            SENIOR_WHITE, SENIOR_ORANGE, SENIOR_GREEN,
            SENIOR_BROWN, SENIOR_RED -> true
            else -> false
        }

    val color: Int
        get() = when (this) {
            WHITE, SENIOR_WHITE -> R.color.white
            ORANGE, SENIOR_ORANGE -> R.color.orange
            GREEN, SENIOR_GREEN -> R.color.green
            BROWN, SENIOR_BROWN -> R.color.brown
            RED, SENIOR_RED -> R.color.red
            BLUE -> R.color.blue
            BLACK -> R.color.black
        }

    fun isAtOrBelow(other: Belt): Boolean {
        return this.ordinal <= other.ordinal
    }

    fun toDisplayName(): String {
        return when (this) {
            WHITE -> "White"
            SENIOR_WHITE -> "Senior White"
            ORANGE -> "Orange"
            SENIOR_ORANGE -> "Senior Orange"
            GREEN -> "Green"
            SENIOR_GREEN -> "Senior Green"
            BROWN -> "Brown"
            SENIOR_BROWN -> "Senior Brown"
            RED -> "Red"
            SENIOR_RED -> "Senior Red"
            BLUE -> "Blue"
            BLACK -> "Black"
        }
    }
}