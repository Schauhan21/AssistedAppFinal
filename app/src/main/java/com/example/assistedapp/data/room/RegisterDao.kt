package com.example.assistedapp.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.assistedapp.data.entity.Register

@Dao
interface RegisterDao{
    @Insert
    suspend fun insert(register: Register)

    @Query("Select * FROM Regsiter_users_table ORDER BY userId DESC")
    fun getAllUsers(): LiveData<List<Register>>

    @Query("SELECT * FROM Regsiter_users_table WHERE user_name LIKE :userName")
    suspend fun getUsername(userName: String): Register?
}