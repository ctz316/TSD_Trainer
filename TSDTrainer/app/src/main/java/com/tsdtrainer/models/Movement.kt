package com.tsdtrainer.app.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class MovementCategory : Parcelable {
    HANDS,
    FEET,
    DEFENSE,
    FORMS
}

@Parcelize
enum class MovementSide : Parcelable {
    REGULAR,
    OPPOSITE,
    NONE  // For forms only
}

@Parcelize
data class Movement(
    val belt: Belt,
    val category: MovementCategory,
    val side: MovementSide = MovementSide.REGULAR,
    val movementNumber: Int = 0,
    val formName: String = "",
    val isWeaponsForm: Boolean = false
) : Parcelable {
    val name: String
        get() = if (category == MovementCategory.FORMS) {
            formName
        } else {
            "${category.name} #$movementNumber"
        }
}