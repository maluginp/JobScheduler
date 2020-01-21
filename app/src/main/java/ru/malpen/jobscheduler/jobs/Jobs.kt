package ru.malpen.jobscheduler.jobs

import android.util.Log

class EmptyJob: Job {
    private val TAG = "EmptyJob"

    override fun execute() {
        Log.d(TAG, "Executing")
        Thread.sleep(1000)
    }

    override val tag: String = TAG

    override fun getPriority(): Int {
        return 1
    }
}