package com.namvox.baitaptuan03

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun UIComponentListScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(36.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Text(
            text = "UI Components List",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp),
            fontSize = 24.sp,
            color = Color.Blue,
        )

        Spacer(modifier = Modifier.height(16.dp))


        SectionTitle("Display")
        ComponentItem(navController, "Text", "Displays text", "text_screen")
        ComponentItem(navController, "Image", "Displays an image","image_screen")

        Spacer(modifier = Modifier.height(16.dp))


        SectionTitle("Input")
        ComponentItem(navController, "TextField", "Input field for text", "textfield_screen")
        ComponentItem(navController, "PasswordField", "Input field for passwords", "password_screen")

        Spacer(modifier = Modifier.height(16.dp))


        SectionTitle("Layout")
        ComponentItem(navController, "Column", "Arranges elements vertically" ,"column_screen")
        ComponentItem(navController, "Row", "Arranges elements horizontally", "row_screen")
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        textAlign = TextAlign.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    )
}

@Composable
fun ComponentItem(navController: NavController, title: String, description: String, route: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .background(
                color = Color(0xFFE6F0FA),
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { navController.navigate(route) }
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp
        )
        Text(
            text = description,
            fontSize = 12.sp,
            color = Color.Gray
        )
    }
}