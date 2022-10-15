package com.mmcoegdsc.bookatable

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.database.FirebaseDatabase
import com.mmcoegdsc.bookatable.data.RestaurantDatabase
import com.mmcoegdsc.bookatable.data.RestaurantItem
import com.mmcoegdsc.bookatable.data.RestaurantRepository
import com.mmcoegdsc.bookatable.restaurants.RestaurantsListScreen
import com.mmcoegdsc.bookatable.ui.theme.BookATableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookATableTheme {
//                RestaurantsListScreen(navController = null)
                Navigation()
//            BottomNav()
            }
        }
    }
}
