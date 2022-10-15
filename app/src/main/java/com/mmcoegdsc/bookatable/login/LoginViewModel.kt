package com.mmcoegdsc.bookatable.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
//import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginViewModel(
    private val stateHandle: SavedStateHandle
):ViewModel() {
    var username = stateHandle.getStateFlow("username","")
    val password = stateHandle.getStateFlow("password","")

    val ref=FirebaseAuth.getInstance()
    val user1 = Firebase.auth.currentUser

//    if (user1 != null) {
////        Log.d("MainActivity","Already signed in")
//    }else{
////        Log.d("MainActivity","Signed Out")
//    }


    fun setVal(key:String,value: String){
        stateHandle[key] = value
    }

    fun signIn(username:String, password:String){
        ref.signInWithEmailAndPassword(username, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
//                        Toast.makeText(this, "Signed IN", Toast.LENGTH_SHORT)
                 //   Log.d("MainActivity","Successful");
                } else {
                   // Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                }
            }
    }


}