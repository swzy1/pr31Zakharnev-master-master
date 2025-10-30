package com.example.a31Zakharnev
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun OnboardScreen1(navController: NavController) {
    OnboardContent(
        image = painterResource(R.drawable.onboard1),
        title = "Добро пожаловать",
        description = "Добавить пользователя",
        navController = navController,
        nextRoute = "onboard_2"
    )
}

@Composable
fun OnboardScreen2(navController: NavController) {
    OnboardContent(
        image = painterResource(R.drawable.onboard2),
        title = "Начнем путешествие",
        description = "Узнайте, как пользоваться магазином и создайте свой стиль",
        navController = navController,
        nextRoute = "onboard_3"
    )
}

@Composable
fun OnboardScreen3(navController: NavController) {
    OnboardContent(
        image = painterResource(R.drawable.onboard3),
        title = "У Вас Есть Сила",
        description = "ВЫ можете выбрать товары и создать стиль",
        navController = navController,
        nextRoute = "sign_in"
    )
}

@Composable
fun OnboardContent(
    image: Painter,
    title: String,
    description: String,
    navController: NavController,
    nextRoute: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF4FC3F7))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = title,
                modifier = Modifier.size(200.dp)
            )
            Text(text = title, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Text(text = description, fontSize = 16.sp, color = Color.White, modifier = Modifier.padding(top = 16.dp))
            Button(
                onClick = { navController.navigate(nextRoute) { popUpTo(nextRoute) { inclusive = false } } },
                modifier = Modifier.padding(top = 32.dp)
            ) {
                Text("Далее")
            }
        }
    }
}