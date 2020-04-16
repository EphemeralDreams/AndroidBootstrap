package com.ephemeraldreams.androidbootstrap.util

import timber.log.Timber

/**
 * A [Timber.Tree] which logs important information for crash reporting.
 */
class CrashReportingTree : Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        TODO("Not yet implemented, pick a crash reporting library.")
    }
}
