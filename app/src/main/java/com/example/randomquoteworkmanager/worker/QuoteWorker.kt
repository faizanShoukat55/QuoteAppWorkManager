package com.example.randomquoteworkmanager.worker

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.randomquoteworkmanager.QuoteApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuoteWorker(private  val context: Context, params: WorkerParameters) : Worker(context,params) {
    override fun doWork(): Result {
        Log.d("WorkManagerTest","Worker Called")
        
        val repository=(context as QuoteApplication).quoteRepository
        CoroutineScope(Dispatchers.IO).launch {
            repository.getQuotesBackground()
        }

        return Result.success()
    }

}