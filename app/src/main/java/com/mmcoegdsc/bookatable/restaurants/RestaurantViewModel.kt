package com.mmcoegdsc.bookatable.restaurants

import android.view.Menu
import androidx.lifecycle.ViewModel
import com.mmcoegdsc.bookatable.data.MenuItem

class RestaurantViewModel:ViewModel(){
//    val menu = mutableListOf<MenuItem>()
//    val restaurants = mutableListOf<String>()



    var menu = listOf<MenuItem>(
        MenuItem("Res",200f),
        MenuItem("Res",200f),
        MenuItem("Res",200f),
        MenuItem("Res",200f),
        MenuItem("Res",200f),
        MenuItem("Res",200f),
        MenuItem("Res",200f),
        MenuItem("Res",200f),
        MenuItem("Res",200f),
    )

    var restaurants = listOf(
        "String1",
        "String1",
        "String1",
        "String1",
        "String1",
        "String1",
        "String1",
        "String1",
        "String1",
        "String1",
    )
}