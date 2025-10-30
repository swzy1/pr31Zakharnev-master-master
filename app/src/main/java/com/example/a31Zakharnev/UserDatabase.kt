package com.example.a31Zakharnev


import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class, Product::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun productDao(): ProductDao
}