package com.example.wheatherappcompose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.wheatherappcompose.ui.theme.BlueLight

@Preview(showBackground = true)
@Composable
fun ListItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 3.dp ),
            colors = CardDefaults.cardColors(containerColor = BlueLight), // Установка цвета фона вместо background
            elevation = CardDefaults.cardElevation(0.dp), // Установка тени
            shape = RoundedCornerShape(5.dp) //закругление углов
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Column(
                modifier = Modifier
                    .padding(
                        start =8.dp,
                        top = 5.dp,
                        bottom = 5.dp)

            ) {
                Text(text = "12:00")
                Text(text = "Sunny",
                    color = Color.White)
            }
            Text(text = "-2°C",
                color = Color.White,
                fontSize = 28.sp)

            AsyncImage(model = "https://cdn.weatherapi.com/weather/64x64/night/122.png",
                contentDescription = "Weather Icon 2",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(35.dp))
        }
    }
}