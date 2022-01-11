package com.example.workmanagerdemo

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class UploadWork(context: Context,workerParameters: WorkerParameters) : Worker(context,workerParameters) {
    override fun doWork(): Result {
        Log.d("mylog", "doWork: start")

        return Result.success()
    }
}