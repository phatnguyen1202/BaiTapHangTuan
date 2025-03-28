package com.namvox.baitap1_tuan4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.namvox.baitap1_tuan4.ui.theme.Baitap1_tuan4Theme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainApp()
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()
    Baitap1_tuan4Theme {
        NavHost(
            navController = navController,
            startDestination = "home"
        ) {
            composable("home") {
                HomeScreen(
                    lazyColumnScreen = { navController.navigate("lazyColumnScreen") }
                )
            }
            composable("lazyColumnScreen") {
                lazyColumnScreen(
                    onBack = { navController.navigate("home") },
                    onNext = { navController.navigate("detailscreen") }
                )
            }
            composable("detailscreen") {
                detailScreen(
                    onBack = { navController.navigate("lazyColumnScreen") },
                    onRoot = { navController.navigate("home") }
                )
            }
        }
    }
}

