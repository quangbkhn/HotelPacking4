@file:Suppress("UNREACHABLE_CODE")

package com.example.quang.hotelpacking.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quang.hotelpacking.Class.User
import com.example.quang.hotelpacking.ClassAdapter.UserAdapter
import com.example.quang.hotelpacking.R
import com.example.quang.hotelpacking.ViewModel.UserViewModel


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class User_fragment : Fragment() {
    var listuser = mutableListOf<User>()
    lateinit var viewmodle: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.user_fragment, container, false)
        var recyclerview = v.findViewById<RecyclerView>(R.id.list_by)
        var recyclerviewadapter = UserAdapter(context,listuser)
        recyclerview.layoutManager = LinearLayoutManager(activity)
        recyclerview.adapter = recyclerviewadapter
        return v
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listuser.add(User("122",12,"1234","hinh","quang","e13","12"))
        listuser.add(User("321",32,"567","123","123","e12","12"))
        listuser.add(User("321",4,"567","123","123","e12","12"))
        listuser.add(User("321",5,"567","123","123","e12","12"))
        listuser.add(User("321",6,"567","123","123","e12","12"))

    }


}
