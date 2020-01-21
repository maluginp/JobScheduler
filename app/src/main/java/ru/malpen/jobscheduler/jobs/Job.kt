package ru.malpen.jobscheduler.jobs

interface Job {
    fun execute()

    val tag: String

    fun getPriority(): Int
}