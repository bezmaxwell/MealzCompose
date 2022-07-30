package com.example.mealzcompose

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import timber.log.Timber

class MyBroadcastReceiver : BroadcastReceiver() {
    private val scope = CoroutineScope(SupervisorJob())

    override fun onReceive(context: Context, intent: Intent) {
        val pendingResult: PendingResult = goAsync()

        scope.launch(Dispatchers.Default) {
            try {
                // Do some background work
                buildString {
                    append("Action: ").append(intent.action).append("\n")
                    append("URI: ").append(intent.toUri(Intent.URI_INTENT_SCHEME)).append("\n")
                }.also { log ->
                    Timber.d(TAG, log)
                }
            } finally {
                // Must call finish() so the BroadcastReceiver can be recycled
                pendingResult.finish()
            }
        }
    }

    companion object {
        private const val TAG = "MyBroadcastReceiver"
    }
}