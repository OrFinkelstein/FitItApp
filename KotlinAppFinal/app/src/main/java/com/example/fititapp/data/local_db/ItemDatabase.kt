package com.example.fititapp.data.local_db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.fititapp.data.models.Convertors
import com.example.fititapp.data.models.Exercise
import com.example.fititapp.data.models.History
import com.example.fititapp.data.models.PersonalData
import com.example.fititapp.data.models.Workout

@Database(entities = [PersonalData::class, Exercise::class, Workout::class, History::class], version = 1, exportSchema = false)
@TypeConverters(Convertors::class)
abstract class ItemDatabase : RoomDatabase() {

    abstract fun personalDataDao() : PersonalDataDao

    abstract fun exerciseDao() : ExerciseDao

    abstract fun workoutDao() : WorkoutDao

    abstract fun historyDao(): HistoryDao

    companion object {

        @Volatile
        private var instance: ItemDatabase? = null

        fun getDatabase(context:Context) = instance ?:
        synchronized(ItemDatabase::class.java) {

            Room.databaseBuilder(context.applicationContext, ItemDatabase::class.java,"items_db")
                .build().also { instance = it }
        }
    }
}