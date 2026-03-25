package com.tsdtrainer.app.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tsdtrainer.app.models.PracticeSession
import com.tsdtrainer.app.models.PracticeType
import java.util.*
import java.util.concurrent.TimeUnit

object PracticeHistoryService {
    private const val PREFS_NAME = "TSDTrainerHistory"
    private const val KEY_SESSIONS = "Sessions"
    private const val MAX_AGE_DAYS = 30L

    private val gson = Gson()
    private var prefs: android.content.SharedPreferences? = null

    fun init(context: Context) {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        cleanOldSessions()
    }

    fun addSession(type: PracticeType, itemCount: Int, durationMinutes: Int) {
        // Safety check - only add if initialized
        if (prefs == null) return

        val sessions = getAllSessions().toMutableList()
        sessions.add(PracticeSession(type, itemCount, durationMinutes, Date()))
        saveSessions(sessions)
    }

    fun getAllSessions(): List<PracticeSession> {
        // Safety check - return empty if not initialized
        val json = prefs?.getString(KEY_SESSIONS, null) ?: return emptyList()
        val type = object : TypeToken<List<PracticeSession>>() {}.type
        return try {
            gson.fromJson(json, type) ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun getRecentSessions(days: Int = 30): List<PracticeSession> {
        val cutoffDate = Calendar.getInstance().apply {
            add(Calendar.DAY_OF_YEAR, -days)
        }.time

        return getAllSessions()
            .filter { it.sessionDate.after(cutoffDate) }
            .sortedByDescending { it.sessionDate }
    }

    private fun saveSessions(sessions: List<PracticeSession>) {
        val json = gson.toJson(sessions)
        prefs?.edit()?.putString(KEY_SESSIONS, json)?.apply()
    }

    /**
     * Automatically remove sessions older than MAX_AGE_DAYS
     */
    private fun cleanOldSessions() {
        val cutoffDate = Calendar.getInstance().apply {
            add(Calendar.DAY_OF_YEAR, -MAX_AGE_DAYS.toInt())
        }.time

        val sessions = getAllSessions()
        val cleaned = sessions.filter { it.sessionDate.after(cutoffDate) }

        if (cleaned.size != sessions.size) {
            saveSessions(cleaned)
        }
    }

    fun clearAllHistory() {
        prefs?.edit()?.remove(KEY_SESSIONS)?.apply()
    }
}