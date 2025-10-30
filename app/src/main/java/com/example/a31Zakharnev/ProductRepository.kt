package com.example.a31Zakharnev

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Room

class ProductRepository {
    private lateinit var database: UserDatabase
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    fun initialize(context: Context) {
        database = Room.databaseBuilder(
            context,
            UserDatabase::class.java, "user-database"
        ).build()
    }

    suspend fun refreshProducts() {
        _products.postValue(database.productDao().getAllProducts())
    }

    suspend fun updateProduct(product: Product) {
        database.productDao().updateProduct(product)
        refreshProducts()
    }
}