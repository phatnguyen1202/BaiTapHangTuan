package com.namvox.baitap2_tuan4

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TaskViewModel : ViewModel() {
    var tasks = mutableStateOf<List<Task>>(emptyList())
    var selectedTask = mutableStateOf<Task?>(null)
    var errorMessage = mutableStateOf<String?>(null)

    fun fetchTasks() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getTasks()
                if (response.isSuccessful) {
                    val taskList = response.body() // Đây là List<Task>
                    tasks.value = taskList ?: emptyList()
                    Log.d("TaskViewModel", "Tasks fetched: ${tasks.value}") // Thêm log để kiểm tra
                } else {
                    errorMessage.value = "Failed to fetch tasks: ${response.message()}"
                }
            } catch (e: Exception) {
                errorMessage.value = "Error: ${e.message}"
            }
        }
    }


    fun fetchTaskById(id: Int) { // sửa về Int
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getTaskById(id)
                if (response.isSuccessful) {
                    selectedTask.value = response.body()
                } else {
                    errorMessage.value = "Failed to fetch task: ${response.message()}"
                }
            } catch (e: Exception) {
                errorMessage.value = "Error: ${e.message}"
            }
        }
    }

    fun deleteTask(id: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.deleteTask(id)
                if (response.isSuccessful) {
                    fetchTasks()
                } else {
                    errorMessage.value = "Failed to delete task: ${response.message()}"
                }
            } catch (e: Exception) {
                errorMessage.value = "Error: ${e.message}"
            }
        }
    }
}

