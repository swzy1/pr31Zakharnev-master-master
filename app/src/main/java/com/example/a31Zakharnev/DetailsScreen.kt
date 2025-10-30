package com.example.a31Zakharnev

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailsScreen(navController: NavController, productId: Int) {
    val viewModel: ProductViewModel = viewModel()
    val products by viewModel.products.observeAsState(emptyList())
    val product = products.find { it.id == productId }

    product?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "Sneaker Shop", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = it.imageRes),
                contentDescription = it.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = it.name, style = MaterialTheme.typography.headlineMedium)
            Text(text = "Men's Shoes", style = MaterialTheme.typography.bodyMedium)
            Text(text = it.price, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Вставка Max Air 270 Обеспечивает\nНепревзойденный Комфорт В Течение Всего Дня. Изящный Дизайн ___", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = { /* TODO: Add to favorites */ }) {
                    Icon(Icons.Default.Favorite, contentDescription = "Favorite")
                }
                Button(
                    onClick = {
                        it.quantityInCart++
                        viewModel.updateProductQuantity(it)
                        navController.navigate("my_cart")
                    },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text("В Корзину")
                }
            }
        }
    }
}
