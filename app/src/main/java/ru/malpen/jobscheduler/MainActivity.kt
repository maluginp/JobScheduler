package ru.malpen.jobscheduler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import ru.malpen.jobscheduler.jobs.EachGroupInThreadExecutor
import ru.malpen.jobscheduler.jobs.EmptyJob

class MainActivity : AppCompatActivity() {

    private val mExecutor = EachGroupInThreadExecutor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tvTextView).setOnClickListener { v ->
            mExecutor.addJob(EmptyJob())
        }

    }
}
