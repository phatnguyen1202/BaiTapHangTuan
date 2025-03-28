package com.namvox.baitap2_tuan3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.namvox.baitap2_tuan3.ui.theme.BaiTap2_Tuan3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           MainApp()
        }
    }
@Composable
     fun MainApp() {
    val navController = rememberNavController()
    BaiTap2_Tuan3Theme {
        NavHost(
            navController = navController,
            startDestination = "home"
        ) {
            composable("home") {
                HomeScreen {
                   navController.navigate("secondscreen")
                }
            }
            composable("secondscreen") {
                SecondScreen(
                    onSkip = {navController.navigate("fourthscreen")},
                    onNext = {navController.navigate("thirdScreen")}
                )
            }
            composable("thirdScreen") {
                thirdScreen(
                    onSkip = {navController.navigate("fourthscreen")},
                    onNext = {navController.navigate("fourthscreen")},
                    onBack = {navController.navigate("secondscreen")}
                )
            }
            composable("fourthscreen") {
                fourthScreen(
                    onSkip = {navController.navigate("home")},
                    onBack = {navController.navigate("thirdScreen")}
                )
            }
        }
    }
    }
}



