package com.mmcoegdsc.bookatable.data
import androidx.lifecycle.LiveData

class RestaurantRepository(private val RestaurantDao:RestaurantDao) {

        val getAllData: LiveData<List<RestaurantItem>> = RestaurantDao.getAll()

        suspend fun addEvent(eventItem: RestaurantItem){
            RestaurantDao.insert(eventItem)
        }
}
