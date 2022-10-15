package com.mmcoegdsc.bookatable.restaurants

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
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
import com.mmcoegdsc.bookatable.data.MenuItem


@Composable
fun RestaurantScreen(
    navController: NavController?,
    viewModel: RestaurantViewModel = viewModel(),
    name: String
) {

    val menu = viewModel.menu

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()
                    .padding(30.dp)
            ) {
                Text(
                    text = name,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 26.sp
                )
            }


            LazyColumn(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                items(menu) { item ->
                    MenuRow(item)
                }
            }
        }
    }
}


@Composable
fun MenuRow(menu: MenuItem) {
    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = menu.item,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                    fontFamily = FontFamily.Serif,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = menu.price.toString(),
                    modifier = Modifier.padding(horizontal = 20.dp),
                    fontSize = 18.sp

                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemPrev() {
    MenuRow(menu = MenuItem("rice", 200f))
}

@Preview(showSystemUi = true)
@Composable
fun menuPrev() {
    RestaurantScreen(navController = null, name = "Resname")
}