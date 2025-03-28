package com.namvox.baitap2_tuan4.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.namvox.baitap2_tuan4.DetailScreen
import com.namvox.baitap2_tuan4.EmptyScreen
import com.namvox.baitap2_tuan4.ListScreen
import com.namvox.baitap2_tuan4.TaskViewModel

@Composable
fun SetupNavGraph(navController: NavHostController, viewModel: TaskViewModel) {
    NavHost(navController = navController, startDestination = "empty") {
        composable("empty") {
            EmptyScreen(
                onNavigateToList = {
                    viewModel.fetchTasks()
                    navController.navigate("list")
                }
            )
        }
        composable("list") {
            ListScreen(
                viewModel = viewModel,
                onNavigateToDetail = { taskId: Int -> // Rõ ràng khai báo taskId là Int
                    viewModel.fetchTaskById(taskId)
                    navController.navigate("detail")
                },
                onBack = {
                    navController.navigate("empty") {
                        popUpTo("list") { inclusive = true }
                    }
                }
            )
        }
        composable("detail") {
            DetailScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() },
                onRoot = {
                    navController.navigate("empty") {
                        popUpTo(navController.graph.startDestinationId) { inclusive = true }
                    }
                }
            )
        }
    }
}