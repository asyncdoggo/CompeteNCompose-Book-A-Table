package com.mmcoegdsc.bookatable.signup

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.mmcoegdsc.bookatable.Routes


class RegisterViewModel(
    private val stateHandle: SavedStateHandle
):ViewModel() {
    var username = stateHandle.getStateFlow("username","")
    val password1 = stateHandle.getStateFlow("password1","")
    val password2 = stateHandle.getStateFlow("password2","")
    val error = stateHandle.getStateFlow("error","")


    fun setVal(key:String,value: String){
        stateHandle[key] = value
    }

    fun signUp(navController: NavController?){
        if(password1 == password2){
            val ref= FirebaseAuth.getInstance()
            ref.createUserWithEmailAndPassword(
                username.value, password1.value
            ).addOnSuccessListener {
                navController?.navigate(Routes.RestaurantListScreen.route)
            }
        }

    }

}