package com.example.wheatherappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.wheatherappcompose.screens.MainCard
import com.example.wheatherappcompose.screens.TabLayout
import com.example.wheatherappcompose.ui.theme.WheatherAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WheatherAppComposeTheme {
                Image(
                    painter = painterResource(id = R.drawable.bg_wheather),
                    contentDescription = "im1",
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(0.5f),  //картинка во весь экран， alpha - прозрачность
                    contentScale = ContentScale.FillBounds
                ) //картинка растягивается во весь экран
                Column {
                    MainCard()
                    TabLayout()

                }
            }
        }
    }
}
