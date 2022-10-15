package com.mmcoegdsc.bookatable.signup

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class RegisterViewModel(
    private val stateHandle: SavedStateHandle
):ViewModel() {
    var username = stateHandle.getStateFlow("username","")
    val password1 = stateHandle.getStateFlow("password1","")
    val password2 = stateHandle.getStateFlow("password2","")


    fun setVal(key:String,value: String){
        stateHandle[key] = value
    }

    fun signUp(username:String,password:String){
        val ref= FirebaseAuth.getInstance()
        ref.createUserWithEmailAndPassword(
            username,
            password
        )
    }

//    fun retrieveDat(){
//
//
//            val storage = FirebaseStorage.getInstance().getReference().child("ImageFolder")
//
//            var database = FirebaseDatabase.getInstance().reference
//
//            var getData = object : ValueEventListener{
//                override fun onCancelled(pO: DatabaseError) {
//                    TODO("Not yet implemented")
//                }
//
//                override fun onDataChange(pO: DataSnapshot) {
//                    var sb = StringBuilder()
//                    for(i in pO.children){
//                        var i1 = i.child("menu/item/name").  getValue()
//                        var i2 = i.child("menu/item/price").getValue()
//                        sb.append("${i.key} $i1 $i2")
//                        println(sb);
//                        println(123);
////                    val tv1: TextView = findViewById(R.id.textView)
////                    tv1.setText()
//                    }
//                }
//            }
//            database.addValueEventListener(getData)
//            database.addListenerForSingleValueEvent(getData)
//    }
}