package com.gigamage.hotelproject.viewmodels



import androidx.lifecycle.ViewModel
import com.gigamage.hotelproject.data.Room
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddRoomViewModel @Inject constructor() : ViewModel() {

    fun addNewRoom(room:Room){
        val database: DatabaseReference = Firebase.database.reference
        database.child("Rooms").child("${room.number}").setValue(room)
    }
}