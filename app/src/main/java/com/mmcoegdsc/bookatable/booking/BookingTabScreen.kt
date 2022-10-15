package com.mmcoegdsc.bookatable.booking

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


data class Booked(
    val name:String,
    val date:String
)


@Composable
fun BookingTabScreen(navController: NavController?) {

    BackHandler {
        navController?.popBackStack()
    }

    val booked = listOf<Booked>(
        Booked("restaurant1","20/20/2022"),
        Booked("restaurant1","20/20/2022"),
        Booked("restaurant1","20/20/2022"),
        Booked("restaurant1","20/20/2022"),
        Booked("restaurant1","20/20/2022"),
        Booked("restaurant1","20/20/2022"),
        Booked("restaurant1","20/20/2022"),
        Booked("restaurant1","20/20/2022"),
    )

    Box(modifier = Modifier.fillMaxSize()){
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                IconButton(onClick = {
                    navController?.popBackStack()
                }) {
                    Icon(imageVector = Icons.Default.ArrowBack,"back")
                }

                Text(
                    text = "Your Booked tables",
                    fontSize = 26.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                )
            }

            LazyColumn(){
                items(booked){item ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Text(text = item.name, fontSize = 18.sp, fontFamily = FontFamily.Serif)
                        Text(text = item.date)
                    }
                }
            }
        }


    }
}


@Preview(showSystemUi = true)
@Composable
fun BookingTabScreenPreview() {
    BookingTabScreen(navController = null)
}