package ru.malpen.jobscheduler.jobs

import java.lang.Exception
import java.util.concurrent.*

class EachGroupInThreadExecutor {
    private val mThreads = mutableMapOf<String, JobDispatcher>()

    fun addJob(job: Job) {
        if (!mThreads.containsKey(job.tag)) {
            mThreads[job.tag] = JobDispatcher()
        }
        mThreads[job.tag]!!.addJob(job)
    }
}

private class JobDispatcher {
    fun addJob(job: Job) {
        waitingTask.add(job)
        if (!thread.isAlive) {
            thread.start()
        }
    }

    fun stop() {
        if (thread.isAlive) {
            thread.interrupt()
        }
    }

    private val waitingTask = PriorityBlockingQueue<Job>(60) {
            job1, job2 -> job1.getPriority().compareTo(job2.getPriority())
    }

    private val thread: Thread = Thread {
        try {
            while (true) {
                val job = waitingTask.poll(5, TimeUnit.SECONDS)
                try {
                    job.execute()

                    //
                } catch (e: Exception) {
                    //
                }
            }
        } catch (e: InterruptedException) {

        } finally {

        }
    }

}