package com.ikigai.rideshare.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ikigai.rideshare.R
import com.ikigai.rideshare.db.trip.TripViewModel
import com.ikigai.rideshare.db.user.UserViewModel
import kotlinx.android.synthetic.main.fragment_trip_list.view.*

class ProfileFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel
    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Recyclerview
        val adapter = UserAdapter()
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // UserViewModel
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            adapter.setData(user)
        })

        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_viewTripFragment)
        }

//        navController = Navigation.findNavController(view)
//        view.findViewById<Button>(R.id.button_view_trip).setOnClickListener(this)
//        view.findViewById<Button>(R.id.button_add_trip).setOnClickListener(this)
        return view
    }


//    override fun onClick(v: View?) {
//        when(v!!.id){
//            R.id.button_view_trip -> navController!!.navigate(R.id.action_profileFragment_to_viewTripFragment)
//            R.id.button_add_trip -> navController!!.navigate(R.id.action_profileFragment_to_createTripFragment)
//        }
//    }

}