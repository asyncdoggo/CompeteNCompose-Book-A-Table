package com.mmcoegdsc.bookatable

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookOnline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Routes(
    val label:String?,
    val icon: ImageVector?,
    val route:String
){
    object LoginScreen : Routes(null,null,"login")
    object SignupScreen : Routes(null,null,"register")
    object Home : Routes(null,null,"home")

    object ProfileScreen : Routes("profile",Icons.Default.Person,"profile")
    object RestaurantScreen : Routes("restaurants",Icons.Default.Restaurant,"restaurant")
    object BookingScreen : Routes("booking",Icons.Default.BookOnline,"booking")
}