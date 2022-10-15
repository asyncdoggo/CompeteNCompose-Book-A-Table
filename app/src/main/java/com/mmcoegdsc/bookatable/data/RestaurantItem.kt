package com.mmcoegdsc.bookatable.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "RestaurantTable")
data class RestaurantItem(
    @PrimaryKey()
    var resId: Int = 0,

    @ColumnInfo(name = "res_name")
    val resName: String,

    @ColumnInfo(name = "isLiked", defaultValue = false.toString())
    val isLiked:Boolean
)