package com.tsdtrainer.app

import android.app.Application
import com.tsdtrainer.app.utils.*

class TSDTrainerApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Initialize all services with application context
        UserSettings.init(this)
        PracticeHistoryService.init(this)
        SpacedRepetitionService.init(this)
        FavoritesManager.init(this)
    }
}