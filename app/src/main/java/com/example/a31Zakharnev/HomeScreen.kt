package com.example.a31Zakharnev

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    Column(modifier = Modifier.fillMaxSize()) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Главная",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Gray
            )
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = MaterialTheme.colorScheme.primary
            )
        }

        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
            placeholder = { Text("Поиск") },
            trailingIcon = { Icon(painterResource(id = android.R.drawable.ic_menu_search), contentDescription = null) },
            singleLine = true
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Категории", style = MaterialTheme.typography.titleMedium)
            Text(text = "Все", color = MaterialTheme.colorScheme.primary)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CategoryChip("Все")
            CategoryChip("Outdoor")
            CategoryChip("Tennis")
        }

        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Популярное", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                items(getPopularProducts()) { product ->
                    ProductCard(product)
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.LightGray.copy(alpha = 0.2f))
                .padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Summer Sale\n15% OFF",
                    color = Color.Magenta,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.width(16.dp))
                Image(
                    painter = painterResource(id = android.R.drawable.ic_menu_gallery),
                    contentDescription = "Sale Image",
                    modifier = Modifier.size(80.dp)
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Icon(
                painter = painterResource(id = android.R.drawable.ic_menu_home),
                contentDescription = "Home",
                tint = MaterialTheme.colorScheme.onSurface
            )
            Icon(
                painter = painterResource(id = android.R.drawable.ic_menu_gallery),
                contentDescription = "Favorites",
                tint = MaterialTheme.colorScheme.onSurface
            )
            FloatingActionButton(
                onClick = { /*  */ },
                containerColor = MaterialTheme.colorScheme.primary,
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_menu_add),
                    contentDescription = "Cart",
                    tint = Color.White
                )
            }
            Icon(
                painter = painterResource(id = android.R.drawable.ic_menu_notifications),
                contentDescription = "Notifications",
                tint = MaterialTheme.colorScheme.onSurface
            )
            Icon(
                painter = painterResource(id = android.R.drawable.ic_menu_my_calendar),
                contentDescription = "Profile",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
fun CategoryChip(category: String) {
    FilterChip(
        selected = false,
        onClick = { /*  */ },
        label = { Text(category) },
        modifier = Modifier.padding(vertical = 4.dp)
    )
}

@Composable
fun ProductCard(product: Product) {
    Card(
        modifier = Modifier
            .width(140.dp)
            .height(200.dp)
            .clip(RoundedCornerShape(12.dp))
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Text(text = "BEST SELLER", color = Color.Gray, fontSize = 12.sp)
            Text(text = product.name, fontWeight = FontWeight.Bold)
            Text(text = product.price, color = MaterialTheme.colorScheme.primary)
            Icon(
                painter = painterResource(id = android.R.drawable.ic_menu_add),
                contentDescription = "Add to Cart",
                modifier = Modifier.clickable { /*  */ }
            )
        }
    }
}

fun getPopularProducts(): List<Product> {
    return listOf(
        Product("Nike Air Max", "₽752.00", android.R.drawable.ic_menu_gallery),
        Product("Nike Air Max", "₽752.00", android.R.drawable.ic_menu_gallery)
    )
}