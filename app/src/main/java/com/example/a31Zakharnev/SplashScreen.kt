package com.example.a31Zakharnev


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF4FC3F7))
    ) {
        Icon(
            imageVector = Icons.Default.ShoppingBag,
            contentDescription = "Splash Icon",
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.Center),
            tint = Color.White
        )
        LaunchedEffect(Unit) {
            delay(2000)
            navController.navigate("onboard_1") {
                popUpTo("splash") { inclusive = true }
            }
        }
    }
}