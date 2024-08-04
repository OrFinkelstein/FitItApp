package com.example.fititapp.data.repostories

import android.app.Application
import com.example.fititapp.data.local_db.ItemDatabase
import com.example.fititapp.data.local_db.WorkoutDao
import com.example.fititapp.data.models.Workout

class WorkoutsRepository(application: Application) {

    private var workoutDao: WorkoutDao?

    init {
        val db  = ItemDatabase.getDatabase(application)
        workoutDao = db.workoutDao()
    }

    fun getItems() = workoutDao?.getItems()

    suspend fun addItem(workout: Workout) {
        workoutDao?.addItem(workout)
    }

    suspend fun deleteItem(workout: Workout) {
        workoutDao?.deleteItem(workout)
    }

    suspend fun deleteAll() {
        workoutDao?.deleteAll()
    }

    suspend fun updateItem(workout: Workout) {
        workoutDao?.updateItem(workout)
    }

}