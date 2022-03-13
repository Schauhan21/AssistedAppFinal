package com.example.assistedapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.assistedapp.data.entity.Category
import com.example.assistedapp.data.entity.Payment

/**
 * The [RoomDatabase] for this app
 */
@Database(
    entities = [Category::class, Payment::class],
    version = 2,
    exportSchema = false
)
abstract class MobileComputingDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun paymentDao(): PaymentDao
}