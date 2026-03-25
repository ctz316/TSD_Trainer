package com.tsdtrainer.app.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class LineMovementType : Parcelable {
    BLOCK,
    PUNCH,
    KICK
}

@Parcelize
data class LineMovement(
    val belt: Belt,
    val name: String,
    val type: LineMovementType
) : Parcelable