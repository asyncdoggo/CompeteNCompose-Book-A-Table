package com.mmcoegdsc.bookatable.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class LoginViewModel(
    private val stateHandle: SavedStateHandle
):ViewModel() {
    var username = stateHandle.getStateFlow("username","")
    val password = stateHandle.getStateFlow("password","")

    fun setVal(key:String,value: String){
        stateHandle[key] = value
    }




}