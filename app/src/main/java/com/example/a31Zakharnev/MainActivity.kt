package com.example.a31Zakharnev

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.a31kotovshchikov.ui.theme._31KotovshchikovTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            DatabaseInitializer.init(this@MainActivity)
        }

        setContent {
            _31KotovshchikovTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "splash") {
                        composable("splash") { SplashScreen(navController) }
                        composable("onboard_1") { OnboardScreen1(navController) }
                        composable("onboard_2") { OnboardScreen2(navController) }
                        composable("onboard_3") { OnboardScreen3(navController) }
                        composable("sign_in") { SignInScreen(navController) }
                        composable("home") { HomeScreen() }
                        composable("popular") { PopularScreen() }
                        composable("my_cart") { MyCartScreen(navController) }
                        composable("search") { SearchScreen(navController) }
                        composable(
                            "details/{productId}",
                            arguments = listOf(navArgument("productId") { defaultValue = "0" })
                        ) { backStackEntry ->
                            DetailsScreen(navController, backStackEntry.arguments?.getString("productId")?.toInt() ?: 0)
                        }
                    }
                }
            }
        }
    }
}