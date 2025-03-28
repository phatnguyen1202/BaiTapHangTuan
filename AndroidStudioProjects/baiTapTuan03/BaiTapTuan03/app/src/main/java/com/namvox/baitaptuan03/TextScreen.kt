package com.namvox.baitaptuan03

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat.Style

@Composable
fun TextScreen() {
   Column(modifier = Modifier
       .padding(0.dp, 400.dp, 0.dp ,0.dp)
       .fillMaxSize(),
       horizontalAlignment = Alignment.CenterHorizontally
   ) {
       val text = buildAnnotatedString {
           append("The ")

           pushStyle(SpanStyle(textDecoration = TextDecoration.LineThrough))
           append("quick ")
           pop()

           pushStyle(
               SpanStyle(fontSize = 30.sp,
               fontWeight = FontWeight.Bold,
                   color = Color(0xFF8B4513)
               )
           )
           append("Brown \n")
           pop()

           append("\nfox j u m p s ")

           pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
           append("over \n")
           pop()

           pushStyle(SpanStyle(textDecoration = TextDecoration.Underline))
           append("\nthe ")
           pop()

           pushStyle(SpanStyle(fontStyle = FontStyle.Italic, fontSize = 16.sp))
           append("lazy ")
           pop()

           append("dog ")
       }
       Text(text = text, fontSize = 32.sp)
   }
}