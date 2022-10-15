package com.mmcoegdsc.bookatable

import com.mmcoegdsc.bookatable.Routes
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.*
import com.mmcoegdsc.bookatable.ui.theme.booking.BookingTabScreen
import com.mmcoegdsc.bookatable.login.LoginScreen
import com.mmcoegdsc.bookatable.ui.theme.profile.ProfileScreen
import com.mmcoegdsc.bookatable.restaurants.RestaurantScreen
import com.mmcoegdsc.bookatable.signup.RegisterScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.LoginScreen.route
    ) {
        composable(route = Routes.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Routes.SignupScreen.route) {
            RegisterScreen(navController)
        }

        composable(route = Routes.Home.route) {
            BottomNav()
        }

    }

}

@Composable
fun BottomNav() {


    val items = listOf(
        Routes.ProfileScreen,
        Routes.RestaurantScreen,
        Routes.BookingScreen
    )

    val bottomNavController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 0.dp,
                backgroundColor = MaterialTheme.colors.background,
                contentColor = MaterialTheme.colors.onBackground,
                title = {
                    Icon(
                        imageVector = Icons.Default.Fastfood,
                        contentDescription = "Logo",
                        modifier = Modifier.size(25.dp)
                    )
                    Text(
                        text = "Book a Table",
                        fontSize = 26.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colors.onBackground,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            )
        },
        bottomBar = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colors.background,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    items.forEach { item ->
                        BottomNavigationItem(
                            icon = { Icon(imageVector = item.icon!!, contentDescription = null) },
                            label = { Text(text = item.label!!, fontSize = 10.sp) },
                            selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                            onClick = {
                                bottomNavController.navigate(item.route) {
                                    popUpTo(bottomNavController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) {
        NavHost(
            navController = bottomNavController,
            modifier = Modifier.padding(it),
            startDestination = Routes.RestaurantScreen.route
        ){
            composable(route = Routes.ProfileScreen.route){
                ProfileScreen(bottomNavController)
            }
            composable(route = Routes.RestaurantScreen.route){
                RestaurantScreen(bottomNavController)
            }
            composable(route = Routes.BookingScreen.route){
                BookingTabScreen(bottomNavController)
            }
        }
    }

}