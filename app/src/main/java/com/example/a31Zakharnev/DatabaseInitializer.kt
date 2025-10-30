package com.example.a31Zakharnev

import android.content.Context
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object DatabaseInitializer {
    suspend fun init(context: Context) {
        withContext(Dispatchers.IO) {
            val db = Room.databaseBuilder(
                context,
                UserDatabase::class.java, "user-database"
            ).build()
            val userDao = db.userDao()
            val productDao = db.productDao()

            val existingUsers = userDao.getAllUsers()
            if (existingUsers.isEmpty()) {
                val users = listOf(
                    User(email = "user1@gmail.com", password = "password1"),
                    User(email = "user2@gmail.com", password = "password2"),
                    User(email = "user3@gmail.com", password = "password3"),
                    User(email = "user4@gmail.com", password = "password4"),
                    User(email = "user5@gmail.com", password = "password5")
                )
                users.forEach { userDao.insertUser(it) }
            }

            val existingProducts = productDao.getAllProducts()
            if (existingProducts.isEmpty()) {
                val products = listOf(
                    Product(name = "Nike Club Max", price = "₽849.95", imageRes = R.drawable.ic_nike_club_max),
                    Product(name = "Nike Air Max 200", price = "₽404.05", imageRes = R.drawable.ic_nike_air_max_200),
                    Product(name = "Nike Air Max 270 Essential", price = "₽179.39", imageRes = R.drawable.ic_nike_air_max_270)
                )
                products.forEach { productDao.insertProduct(it) }
            }
        }
    }
}