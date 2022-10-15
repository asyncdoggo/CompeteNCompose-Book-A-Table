package com.mmcoegdsc.bookatable.signup

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class RegisterViewModel(
    private val stateHandle: SavedStateHandle
):ViewModel() {
    var username = stateHandle.getStateFlow("username","")
    val password1 = stateHandle.getStateFlow("password1","")
    val password2 = stateHandle.getStateFlow("password2","")

    fun setVal(key:String,value: String){
        stateHandle[key] = value
    }
}