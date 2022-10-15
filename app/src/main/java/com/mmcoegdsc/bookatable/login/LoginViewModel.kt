package com.mmcoegdsc.bookatable.login

//import com.google.android.material.textfield.TextInputEditText
import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.mmcoegdsc.bookatable.Routes
import com.mmcoegdsc.bookatable.data.RestaurantDatabase
import com.mmcoegdsc.bookatable.data.RestaurantItem
import com.mmcoegdsc.bookatable.data.RestaurantRepository
import kotlinx.coroutines.launch

class LoginViewModel(
    private val stateHandle: SavedStateHandle
):ViewModel() {
    var username = stateHandle.getStateFlow("username","")
    val password = stateHandle.getStateFlow("password","")
    val error = stateHandle.getStateFlow("error","")

    val ref=FirebaseAuth.getInstance()
    val user1 = Firebase.auth.currentUser


    fun setVal(key:String,value: String){
        stateHandle[key] = value
    }

    fun signIn(navController: NavController?){
        ref.signInWithEmailAndPassword(username.value, password.value)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    navController?.navigate(Routes.RestaurantListScreen.route)

                } else {
                    stateHandle["error"] = "username or password is incorrect"
                }
            }
    }


    fun retrieveData(context: Context){

        val resDao = RestaurantDatabase.getInstance(context).eventDao()
        val repository = RestaurantRepository(resDao)

        val database = FirebaseDatabase.getInstance().reference
        val data = mutableMapOf<String,MutableMap<String,Long>>()
        database.child("Restaurant").get().addOnSuccessListener {
            for(i in it.children){
                val temp = mutableMapOf<String,Long>()
                for(j in i.children){
                    temp[j.key?:""] = j.value as Long
                }
                data[i.key?:""] = temp
            }
            for(i in data.keys){
                viewModelScope.launch {
                    repository.addRestaurant(resItem = RestaurantItem(0,i,false))
                }
            }
        }
    }


}