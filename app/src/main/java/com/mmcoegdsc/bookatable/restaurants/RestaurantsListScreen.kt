package com.mmcoegdsc.bookatable.restaurants

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material.icons.filled.Start
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun RestaurantsListScreen(
    navController: NavController?,
    viewModel: RestaurantViewModel = viewModel()
) {
    val restaurants = viewModel.restaurants


    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp)
            ) {
                Text(
                    text = "Restaurants",
                    fontSize = 26.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                )
            }
            LazyColumn(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                items(restaurants){item ->
                    RestaurantItem(item = item, isLiked = listOf(true,false).random()){

                    }
                }
            }

        }
    }
}


@Composable
fun RestaurantItem(item:String,isLiked: Boolean,onClick:(String)->Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick(item)
            }
            .padding(20.dp)
    ) {
        Text(
            text = item,
            fontSize = 18.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Medium
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = if(isLiked) Icons.Default.StarOutline else Icons.Default.Star,
                contentDescription = "Like"
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PrevREs() {
    RestaurantsListScreen(navController = null)
}
