package com.tsdtrainer.app.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tsdtrainer.app.models.PracticeType

object FavoritesManager {
    private const val PREFS_NAME = "TSDFavorites"
    private val gson = Gson()
    private var prefs: android.content.SharedPreferences? = null
    private val favoritesCache = mutableMapOf<String, MutableSet<String>>()

    fun init(context: Context) {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        loadAllFavorites()
    }

    private fun loadAllFavorites() {
        PracticeType.values().forEach { type ->
            loadFavorites(type)
        }
    }

    private fun loadFavorites(type: PracticeType): MutableSet<String> {
        val key = type.name
        if (favoritesCache.containsKey(key)) {
            return favoritesCache[key] ?: mutableSetOf()
        }

        val json = prefs?.getString(key, null)
        val favorites = if (json != null) {
            val setType = object : TypeToken<MutableSet<String>>() {}.type
            gson.fromJson<MutableSet<String>>(json, setType)
        } else {
            mutableSetOf()
        }

        favoritesCache[key] = favorites
        return favorites
    }

    private fun saveFavorites(type: PracticeType) {
        val key = type.name
        val favorites = favoritesCache[key] ?: return
        val json = gson.toJson(favorites)
        prefs?.edit()?.putString(key, json)?.apply()
    }

    fun isFavorite(type: PracticeType, itemName: String): Boolean {
        val favorites = loadFavorites(type)
        return favorites.contains(itemName)
    }

    fun addFavorite(type: PracticeType, itemName: String) {
        val favorites = loadFavorites(type)
        favorites.add(itemName)
        saveFavorites(type)
    }

    fun removeFavorite(type: PracticeType, itemName: String) {
        val favorites = loadFavorites(type)
        favorites.remove(itemName)
        saveFavorites(type)
    }

    fun toggleFavorite(type: PracticeType, itemName: String) {
        if (isFavorite(type, itemName)) {
            removeFavorite(type, itemName)
        } else {
            addFavorite(type, itemName)
        }
    }

    fun getFavorites(type: PracticeType): Set<String> {
        return loadFavorites(type).toSet()
    }

    fun clearFavorites(type: PracticeType) {
        favoritesCache[type.name] = mutableSetOf()
        saveFavorites(type)
    }
}