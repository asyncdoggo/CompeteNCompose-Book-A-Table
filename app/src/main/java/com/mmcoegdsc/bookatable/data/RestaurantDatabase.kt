package com.mmcoegdsc.bookatable.data


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RestaurantItem::class], version = 1, exportSchema = false)
abstract class RestaurantDatabase: RoomDatabase() {
    abstract fun eventDao(): RestaurantDao

    companion object{
        private var INSTANCE: RestaurantDatabase? = null

        fun getInstance(context: Context): RestaurantDatabase{
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RestaurantDatabase::class.java,
                        "todo_list_database"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}