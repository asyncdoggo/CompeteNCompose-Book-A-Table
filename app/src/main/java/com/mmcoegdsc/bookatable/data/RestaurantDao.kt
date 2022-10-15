package com.mmcoegdsc.bookatable.data


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RestaurantDao {
    @Query("SELECT * FROM RestaurantTable")
    fun getAll():LiveData<List<RestaurantItem>>

    @Query("SELECT * FROM RestaurantTable where resId = :id")
    fun getEventById(id:Int):RestaurantItem?

    @Insert
    suspend fun insert(item: RestaurantItem)
}