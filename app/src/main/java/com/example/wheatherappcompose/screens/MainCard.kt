package com.example.wheatherappcompose.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.wheatherappcompose.R
import com.example.wheatherappcompose.data.WeatherModel
import com.example.wheatherappcompose.ui.theme.BlueLight
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun MainCard() {
    Column(
        modifier = Modifier
            .padding(5.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 0.dp),
            colors = CardDefaults.cardColors(BlueLight),
            shape = RoundedCornerShape(5.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Дата и иконка
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.padding(top = 8.dp, start = 8.dp),
                        text = "26 Jun 2025 2:00",
                        style = TextStyle(fontSize = 15.sp),
                        color = Color.White
                    )
                    AsyncImage(
                        model = "https://cdn.weatherapi.com/weather/64x64/night/122.png",
                        contentDescription = "Weather Icon",
                        modifier = Modifier
                            .padding(top = 8.dp, end = 8.dp)
                            .size(35.dp)
                    )
                }

                // Город, температура, состояние
                Text(
                    text = "Madrid",
                    style = TextStyle(fontSize = 24.sp),
                    color = Color.White
                )
                Text(
                    text = "10 °C",
                    style = TextStyle(fontSize = 65.sp),
                    color = Color.White
                )
                Text(
                    text = "Sunny",
                    style = TextStyle(fontSize = 16.sp),
                    color = Color.White
                )

                // Нижние иконки и температура
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { /* TODO: Add search action */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = "Search Icon",
                            tint = Color.White
                        )
                    }

                    Text(
                        text = "23 °C/10 °C",
                        style = TextStyle(fontSize = 16.sp),
                        color = Color.White
                    )

                    IconButton(onClick = { /* TODO: Add refresh action */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.sync),
                            contentDescription = "Sync Icon",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabLayout() {
    val tabList = listOf("HOUR", "DAYS")
    val pagerState = rememberPagerState(
        initialPage = 0, // Начальная страница
        pageCount = { tabList.size } // Количество страниц
    )

    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .padding(start = 5.dp, end = 5.dp)
            .clip(RoundedCornerShape(5.dp)) // Форма карточки закругленная
    ) {
        // TabRow для отображения вкладок
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                    height = 4.dp,
                    color = Color.White // Цвет индикатора
                )
            },
            containerColor = BlueLight
        ) {
            tabList.forEachIndexed { index, text ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index) // Анимация перехода к странице
                        }
                    },
                    text = {
                        Text(text = text)
                    }
                )
            }
        }

        // HorizontalPager для отображения контента внутри вкладок
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1.0f)
        ) { index ->
            // Содержимое каждой страницы
            when (index) {
                0 -> LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ){
                    itemsIndexed(
                        listOf(WeatherModel(
                            city = "Madrid",
                            time = "2:00",
                            condition = "Sunny",
                            icon = "//cdn.weatherapi.com/weather/64x64/night/296.png",
                            currentTemp = "10 °C",
                            maxTemp = "",
                            minTemp = "",
                            hours = ""
                        )
                        )
                    ){
                        _, item ->
                        ListItem(item = item)
                    }
                }

                1 -> LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    itemsIndexed(
                        listOf(WeatherModel(
                            city = "Madrid",
                            time = "26 Jun 2025",
                            condition = "Sunny",
                            icon = "//cdn.weatherapi.com/weather/64x64/night/296.png",
                            currentTemp = "",
                            maxTemp = "23°",
                            minTemp = "10°",
                            hours = ""
                        )
                        )
                    ){
                            _, item ->
                        ListItem(item = item)
                    }

                }
            }
        }

    }
}



