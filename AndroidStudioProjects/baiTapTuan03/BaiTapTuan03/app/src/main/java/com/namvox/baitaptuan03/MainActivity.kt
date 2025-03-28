package com.namvox.baitaptuan03

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
import com.namvox.baitaptuan03.ui.theme.BaiTapTuan03Theme

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
    BaiTapTuan03Theme {
        NavHost(
            navController = navController,
            startDestination = "home"
        ) {
            composable("home") {
                HomeScreen(
                    openUIComponentList = { navController.navigate("ui_component_list") }
                )
            }
            composable("ui_component_list") {
                UIComponentListScreen(navController = navController)
            }
            composable("text_screen") {
                TextScreen()
            }
            composable("image_screen"){
                ImageScreen()
            }
            composable("textfield_screen") {
                TextFieldScreen()
            }
            composable("password_screen") {
                PasswordFieldScreen()
            }
            composable("column_screen") {
                ColumnScreen()
            }
            composable("row_screen") {
                RowScreen()
            }
        }

    }
}

