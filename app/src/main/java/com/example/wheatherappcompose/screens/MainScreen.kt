package com.example.wheatherappcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.wheatherappcompose.R
import com.example.wheatherappcompose.ui.theme.BlueLight


@Preview (showBackground = true)
@Composable
fun MainScreen() {
    Image(painter = painterResource(id = R.drawable.bg_wheather),
        contentDescription = "im1",
        modifier = Modifier.fillMaxSize().alpha(0.5f),  //картинка во весь экран， alpha - прозрачность
        contentScale = ContentScale.FillBounds) //картинка растягивается во весь экран

    Column(
        modifier = Modifier.fillMaxSize().padding(5.dp)
    )
        {
        Card(
            modifier = Modifier.shadow(elevation = 0.dp).fillMaxWidth(), // тень карточки
            colors = CardDefaults.cardColors(BlueLight), //цвет карточки
            shape = RoundedCornerShape(5.dp) //форма карточки закругленная
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween)
                    {
                    Text(
                        modifier = Modifier.padding(top = 8.dp, start = 8.dp),
                        text = "26 Jun 2025 2:00",
                        style = TextStyle(fontSize = 15.sp),
                        color = Color.White
                    )
                      AsyncImage(
                          model ="https://cdn.weatherapi.com/weather/64x64/night/122.png",
                          contentDescription = "im2",
                          modifier = Modifier
                              .size(35.dp)
                              .padding(top = 3.dp, end = 8.dp))

                }
            }
        }

    }

}

