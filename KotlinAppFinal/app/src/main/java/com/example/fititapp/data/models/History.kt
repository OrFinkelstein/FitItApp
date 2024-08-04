package com.example.fititapp.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "history_table")
@TypeConverters(WorkoutConverter::class)
data class History(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "date")
    val date: String,

    @ColumnInfo(name = "time")
    val time: String,

    @ColumnInfo(name = "workout")
    val workout: Workout?,

//    @ColumnInfo(name = "meals")
//    val meals: String?,

    @ColumnInfo(name = "intensity_level")
    val intensity_level: Int,

//    @ColumnInfo(name = "duration")
//    val duration: Long
)

