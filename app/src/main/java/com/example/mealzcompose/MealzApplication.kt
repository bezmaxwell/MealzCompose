package com.example.mealzcompose

import timber.log.Timber
import android.app.Application
import timber.log.BuildConfig

class MealzApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            // TODO() Implement Timber dependencies to proceed to register logs
            /**
             * Caso esteja gerando um apk de debug, será plantada uma árvore para imprimir todas as chamadas feitas
             * a classe do Timber para o Logcat. Ao gerar um apk de release, nenhuma árvore será plantada e nada aparecerá lá.
             */
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(CrashlyticsReportingTree())
        }
    }
}