package com.example.a31Zakharnev


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    private val repository = ProductRepository()

    val products: LiveData<List<Product>> = repository.products

    init {
        viewModelScope.launch {
            repository.refreshProducts()
        }
    }

    fun updateProductQuantity(product: Product) {
        viewModelScope.launch {
            repository.updateProduct(product)
        }
    }
}


