package com.tsdtrainer.app.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlin.random.Random

/**
 * Implements spaced repetition algorithm for optimal learning
 * Tracks how well the user knows each item and prioritizes showing
 * items that need more practice
 */
object SpacedRepetitionService {
    private const val PREFS_NAME = "TSDTrainerSpacedRepetition"
    private const val KEY_ITEM_SCORES = "ItemScores"

    // Spaced repetition constants
    private const val INITIAL_WEIGHT = 5.0f
    private const val MIN_WEIGHT = 0.5f
    private const val MAX_WEIGHT = 10.0f
    private const val CORRECT_MULTIPLIER = 0.7f
    private const val INCORRECT_MULTIPLIER = 1.5f

    private val gson = Gson()
    private var prefs: android.content.SharedPreferences? = null
    private val scoreCache = mutableMapOf<String, Float>()

    fun init(context: Context) {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        loadScores()
    }

    private fun loadScores() {
        val json = prefs?.getString(KEY_ITEM_SCORES, null)
        if (json != null) {
            val type = object : TypeToken<MutableMap<String, Float>>() {}.type
            val loaded = gson.fromJson<MutableMap<String, Float>>(json, type)
            scoreCache.putAll(loaded)
        }
    }

    private fun saveScores() {
        val json = gson.toJson(scoreCache)
        prefs?.edit()?.putString(KEY_ITEM_SCORES, json)?.apply()
    }

    /**
     * Get weighted probabilities for a list of items
     * Items with higher weights should be shown more often
     * Returns map of item -> weight
     */
    fun getWeightedItems(availableItems: List<String>): Map<String, Float> {
        val weights = mutableMapOf<String, Float>()

        for (item in availableItems) {
            val score = scoreCache[item] ?: INITIAL_WEIGHT
            weights[item] = score.coerceIn(MIN_WEIGHT, MAX_WEIGHT)
        }

        return weights
    }

    /**
     * Record that an item was shown to the user
     * @param itemId Unique identifier for the item
     * @param wasCorrectOrFast True if user answered correctly or quickly
     */
    fun recordItemShown(itemId: String, wasCorrectOrFast: Boolean = false) {
        val currentScore = scoreCache[itemId] ?: INITIAL_WEIGHT

        val newScore = if (wasCorrectOrFast) {
            // User knows this well, reduce weight (show less often)
            currentScore * CORRECT_MULTIPLIER
        } else {
            // User needs more practice, increase weight (show more often)
            currentScore * INCORRECT_MULTIPLIER
        }

        scoreCache[itemId] = newScore.coerceIn(MIN_WEIGHT, MAX_WEIGHT)
        saveScores()
    }

    /**
     * Get the current score/weight for an item
     */
    fun getItemScore(itemId: String): Float {
        return scoreCache[itemId] ?: INITIAL_WEIGHT
    }

    /**
     * Reset score for a specific item
     */
    fun resetItemScore(itemId: String) {
        scoreCache.remove(itemId)
        saveScores()
    }

    /**
     * Reset all scores
     */
    fun resetAllScores() {
        scoreCache.clear()
        saveScores()
    }

    /**
     * Get statistics about learned items
     */
    fun getStats(): Map<String, Int> {
        val wellKnown = scoreCache.count { it.value < 2.0f }
        val needsPractice = scoreCache.count { it.value > 7.0f }
        val total = scoreCache.size

        return mapOf(
            "total" to total,
            "wellKnown" to wellKnown,
            "needsPractice" to needsPractice
        )
    }

    /**
     * Select next item to show based on spaced repetition weights.
     * Items with higher weights (need more practice) are more likely to be selected.
     * @param practiceType The type of practice session
     * @param availableItems List of available item names/IDs
     * @return Selected item ID, or null if list is empty
     */
    fun getNextItem(practiceType: com.tsdtrainer.app.models.PracticeType, availableItems: List<String>): String? {
        if (availableItems.isEmpty()) return null
        if (availableItems.size == 1) return availableItems[0]

        // Get weights for all items
        val weights = getWeightedItems(availableItems)

        // Calculate total weight
        val totalWeight = weights.values.sum()

        if (totalWeight <= 0) {
            // Fallback to random if no weights
            return availableItems.random()
        }

        // BUG FIX #4 (MINOR): Replaced Java's Math.random() with Kotlin-idiomatic
        // Random.nextDouble() for consistency and to avoid unnecessary Java interop.
        var random = Random.nextDouble() * totalWeight

        for ((item, weight) in weights) {
            random -= weight
            if (random <= 0) {
                return item
            }
        }

        // Fallback (shouldn't reach here)
        return availableItems.random()
    }
}