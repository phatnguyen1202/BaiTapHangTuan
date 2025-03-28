package com.namvox.baitap2_tuan4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController // Import rememberNavController
import com.namvox.baitap2_tuan4.navigation.SetupNavGraph // Import SetupNavGraph

class MainActivity : ComponentActivity() {
    private val viewModel = TaskViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(viewModel)
        }
    }
}

@Composable
fun App(viewModel: TaskViewModel) {
    val navController = rememberNavController()
    SetupNavGraph(navController = navController, viewModel = viewModel)
}