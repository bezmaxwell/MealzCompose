package com.example.mealzcompose;

import android.util.Log;
import timber.log.Timber;

// TODO() Import and implement dependencies Timber and Crashlytics
public class CrashlyticsReportingTree extends Timber.Tree{

    @Override
    protected void log(int priority, String tag, String message,Throwable t) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG){
            return;
        }

        if (t != null) {
            if (priority == Log.ERROR || priority == Log.WARN) {
                //Crashlytics.logException(t);
            }
        }
    }
}