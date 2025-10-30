package com.example.a31Zakharnev

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MyCartScreen(navController: NavController) {
    val viewModel: ProductViewModel = viewModel()
    val products by viewModel.products.observeAsState(emptyList())

    val cartItems = products.filter { it.quantityInCart > 0 }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Корзина",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(cartItems) { product ->
                CartItemCard(product, viewModel)
            }
        }
        Divider(modifier = Modifier.padding(vertical = 16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Сумма")
            Text(text = "₽${cartItems.sumOf { it.price.replace("₽", "").toDouble() * it.quantityInCart }}.95")
            Text(text = "Доставка")
            Text(text = "₽60.20")
        }
        Divider(modifier = Modifier.padding(vertical = 16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Итого")
            Text(text = "₽${cartItems.sumOf { it.price.replace("₽", "").toDouble() * it.quantityInCart } + 60.20}.15")
        }
        Button(
            onClick = { /* */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Text(text = "Оформить заказ")
        }
    }
}

@Composable
fun CartItemCard(product: Product, viewModel: ProductViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = product.name, fontWeight = FontWeight.Bold)
                Text(text = "₽${product.price}", color = MaterialTheme.colorScheme.primary)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = {
                    if (product.quantityInCart > 0) {
                        product.quantityInCart--
                        viewModel.updateProductQuantity(product)
                    }
                }) {
                    Icon(Icons.Default.Remove, contentDescription = "Decrease")
                }
                Text(text = "${product.quantityInCart}", modifier = Modifier.padding(horizontal = 8.dp))
                IconButton(onClick = {
                    product.quantityInCart++
                    viewModel.updateProductQuantity(product)
                }) {
                    Icon(Icons.Default.Add, contentDescription = "Increase")
                }
                IconButton(onClick = {
                    product.quantityInCart = 0
                    viewModel.updateProductQuantity(product)
                }) {
                    Icon(Icons.Default.Delete, contentDescription = "Remove", tint = Color.Red)
                }
            }
        }
    }
}
