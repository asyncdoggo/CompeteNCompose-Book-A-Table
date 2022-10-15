package com.mmcoegdsc.bookatable.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mmcoegdsc.bookatable.data.RestaurantData
import com.mmcoegdsc.bookatable.restaurants.RestaurantItem


@Composable
fun UserProfileScreen(
    viewModel: ProfileViewModel = viewModel(),
    navController: NavController?
) {
    Box(modifier = Modifier.fillMaxSize()) {
        val uname = "uname"
        val name = "name"

        val likedRes = listOf<RestaurantData>(
            RestaurantData("res", listOf(true,false).random()),
            RestaurantData("res", listOf(true,false).random()),
            RestaurantData("res", listOf(true,false).random()),
            RestaurantData("res", listOf(true,false).random()),
            RestaurantData("res", listOf(true,false).random()),
            RestaurantData("res", listOf(true,false).random()),
            RestaurantData("res", listOf(true,false).random()),
            RestaurantData("res", listOf(true,false).random()),
            RestaurantData("res", listOf(true,false).random()),
        )

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
                    .padding(30.dp)
            ) {
                Text(
                    text = "your profile",
                    fontSize = 26.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp)
            ) {
                Text(
                    text = uname,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                )
            }
           LazyColumn(
               verticalArrangement = Arrangement.Center,
               horizontalAlignment = Alignment.CenterHorizontally,
               modifier = Modifier.fillMaxSize()
           ){
               items(likedRes){item ->
                    RestaurantItem(item = item.name,item.isLiked){
                        viewModel.liked(item)
                    }
               }
           }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfPrev() {
    UserProfileScreen(navController = null)
}