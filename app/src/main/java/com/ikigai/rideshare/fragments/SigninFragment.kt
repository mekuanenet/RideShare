package com.ikigai.rideshare.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ikigai.rideshare.R
import com.ikigai.rideshare.db.credentials.Credent
import com.ikigai.rideshare.db.credentials.CredentialViewModel
import com.ikigai.rideshare.db.trip.TripViewModel
import kotlinx.android.synthetic.main.fragment_signin.*
import kotlinx.android.synthetic.main.fragment_signin.view.*

class SigninFragment : Fragment() {

    private lateinit var credentialViewModel: CredentialViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_signin, container, false)

        credentialViewModel = ViewModelProvider(this).get(CredentialViewModel::class.java)
        view.signIn_logIn.setOnClickListener {
            checkCredentials()
        }
        return view
    }

    private fun checkCredentials() {
        val userName = signIn_userName.text.toString()
        val password = signIn_password.text.toString()
//        listCredentList<Credent> = credentialViewModel.readAllData
    }
}