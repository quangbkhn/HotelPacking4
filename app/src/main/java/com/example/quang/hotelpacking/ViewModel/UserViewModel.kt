package com.example.quang.hotelpacking.ViewModel

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.quang.hotelpacking.Class.User
import java.lang.IllegalArgumentException

class UserViewModel(var datauser: LiveData<User>) :ViewModel() {
    fun getUser():LiveData<User>{
        return datauser
    }
}
