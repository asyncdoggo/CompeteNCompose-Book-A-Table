package com.mmcoegdsc.bookatable.restaurants

import android.content.Context
import android.view.Menu
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.mmcoegdsc.bookatable.data.MenuItem
import com.mmcoegdsc.bookatable.data.RestaurantDatabase
import com.mmcoegdsc.bookatable.data.RestaurantItem
import com.mmcoegdsc.bookatable.data.RestaurantRepository

class RestaurantViewModel:ViewModel(){
//    val menu = mutableListOf<MenuItem>()
//    val restaurants = mutableListOf<String>()



    var menu = listOf<MenuItem>()

    var restaurants = mutableListOf<RestaurantItem>()


    fun getres(context :Context): LiveData<List<RestaurantItem>> {
        val resDao = RestaurantDatabase.getInstance(context).eventDao()
        val repository = RestaurantRepository(resDao)
        return repository.getAllData
    }

}