package com.example.fititapp.data.local_db
import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.example.fititapp.data.models.Exercise

@Dao
interface ExerciseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(exercise: Exercise)

    @Update
    suspend fun updateItem(exercise: Exercise)

    @Delete
    suspend fun deleteItem(exercise: Exercise)

    @Query("SELECT * FROM exercises")
    fun getItems(): LiveData<List<Exercise>>

    @Query("DELETE from exercises")
    suspend fun deleteAll()
}