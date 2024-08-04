package com.example.fititapp.data.repostories

import android.app.Application
import com.example.fititapp.data.local_db.ItemDatabase
import com.example.fititapp.data.local_db.PersonalDataDao
import com.example.fititapp.data.models.PersonalData

class PersonalDataRepository(application: Application) {

        private var personalDataDao: PersonalDataDao?

        init {
            val db  = ItemDatabase.getDatabase(application)
            personalDataDao = db.personalDataDao()
        }

        fun getOnlyItem() = personalDataDao?.getOnlyItem()

        suspend fun addItem(item: PersonalData) {
            personalDataDao?.addItem(item)
        }

        suspend fun deleteItem(item: PersonalData) {
            personalDataDao?.deleteItem(item)
        }

        suspend fun deleteAll() {
            personalDataDao?.deleteAll()
        }

}