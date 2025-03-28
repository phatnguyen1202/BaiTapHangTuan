package com.namvox.baitap2_tuan3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen(onSkip: () -> Unit, onNext: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Row {
                repeat(3) { index ->
                    Box(
                        modifier = Modifier
                            .size(if (index == 0) 8.dp else 6.dp)
                            .background(
                                if(index == 0) Color.Blue else Color.Gray,
                                shape = CircleShape
                            )
                            .padding(4.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                }
            }
            Text(
                text = "Skip",
                color = Color.Blue,
                fontSize = 16.sp,
                modifier = Modifier.clickable{onSkip()}
            )
        }
        Image(
            painter = painterResource(id = R.drawable.img_scr2),
            contentDescription = null,
            modifier = Modifier.padding(top = 150.dp)
                .size(250.dp),
        )
        Text(
            text = "Easy Time Management\n",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "With management based on priority and\n" +
                    " daily tasks, it will give you convenience in\n" +
                    " managing and determining the tasks that\n" +
                    " must be done first ",
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {onNext()},
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Next")
        }
    }

}