package com.ikigai.rideshare.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ikigai.rideshare.R
import com.ikigai.rideshare.db.trip.TripViewModel
import kotlinx.android.synthetic.main.fragment_trip_list.view.*

class ViewTripFragment :Fragment() {

    private lateinit var tripViewModel: TripViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_view_trip, container, false)

        // Recyclerview
        val adapter = TripAdapter()
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // UserViewModel
        tripViewModel = ViewModelProvider(this).get(TripViewModel::class.java)
        tripViewModel.readAllData.observe(viewLifecycleOwner, Observer { trip ->
            adapter.setData(trip)
        })

        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_viewTripFragment_to_createTripFragment)
        }

        return view
    }
}