package com.tsdtrainer.app.utils

import android.content.Context
import android.content.SharedPreferences
import com.tsdtrainer.app.models.Belt

object UserSettings {
    private const val PREFS_NAME = "TSDTrainerPrefs"
    private const val KEY_BELT = "UserBelt"

    private var prefs: SharedPreferences? = null

    fun init(context: Context) {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun getBelt(): Belt {
        // Safety check - if not initialized, return WHITE belt as safe default
        val beltRank = prefs?.getInt(KEY_BELT, Belt.WHITE.rank) ?: Belt.WHITE.rank
        return Belt.values().find { it.rank == beltRank } ?: Belt.WHITE
    }

    fun setBelt(belt: Belt) {
        // Safety check - only save if initialized
        prefs?.edit()?.putInt(KEY_BELT, belt.rank)?.apply()
    }
}