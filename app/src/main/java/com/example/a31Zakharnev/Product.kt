package com.example.a31Zakharnev

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val price: String,
    val imageRes: Int,
    var quantityInCart: Int = 0
)