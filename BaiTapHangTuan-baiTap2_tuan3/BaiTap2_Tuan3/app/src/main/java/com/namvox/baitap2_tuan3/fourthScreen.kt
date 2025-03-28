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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun fourthScreen( onSkip: () -> Unit, onBack: () -> Unit) {
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
                            .size(if (index == 2) 8.dp else 6.dp)
                            .background(
                                if (index == 2) Color.Blue else Color.Gray,
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
                modifier = Modifier.clickable { onSkip() }
            )
        }
        Image(
            painter = painterResource(id = R.drawable.img_fourthscr),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 150.dp)
                .size(250.dp),
        )
        Text(
            text = "Reminder Notification\n",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "The advantage of this application is that it\n" +
                    " also provides reminders for you so you\n" +
                    " don't forget to keep doing your\n" +
                    " assignments well and according to the\n" +
                    " time you have set",
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(Color.Blue),
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = { onBack() }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.btn_back_24),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Get Started")
            }
        }

    }
}

