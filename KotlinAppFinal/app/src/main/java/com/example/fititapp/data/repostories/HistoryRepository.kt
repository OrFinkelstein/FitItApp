package com.example.fititapp.data.repostories

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.fititapp.data.local_db.ItemDatabase
import com.example.fititapp.data.local_db.HistoryDao
import com.example.fititapp.data.models.History

class HistoryRepository(application: Application) {

    private var historyDao: HistoryDao?

    init {
        val db  = ItemDatabase.getDatabase(application)
        historyDao = db.historyDao()
    }

    suspend fun insert(history: History) {
        historyDao?.insert(history)
    }

    suspend fun deleteHistoryByDate(date: String){
        historyDao?.deleteHistoryByDate(date)
    }

    fun getHistoryByDate(date: String) : LiveData<History?>? {
        return historyDao?.getHistoryByDate(date)
    }

    fun getFirstHistory() = historyDao?.getFirstHistory()

    suspend fun getAllHistory(): List<History>? {
        return historyDao?.getAllHistoryList() // Assuming you have a method to get the list directly
    }

}
