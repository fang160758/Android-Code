package com.example.workmanagerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.WorkSource
import android.view.View
import android.widget.Button
import androidx.work.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val button:Button = findViewById(R.id.button)
        button.setOnClickListener{
//            val workRequest:WorkRequest =
//                OneTimeWorkRequestBuilder<UploadWork>()
//                    .build()
//            val wokeRequest:WorkRequest = OneTimeWorkRequest.from(UploadWork::class.java)

            val request = PeriodicWorkRequest.Builder(UploadWork::class.java,1,TimeUnit.HOURS).build()
            WorkManager
                .getInstance(this)
                .enqueue(request)
        }


    }
}