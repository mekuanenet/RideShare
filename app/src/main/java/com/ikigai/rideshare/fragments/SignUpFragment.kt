package com.ikigai.rideshare.fragments

import android.net.wifi.hotspot2.pps.Credential
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.lifecycle.ViewModelProvider
import com.ikigai.rideshare.R
import com.ikigai.rideshare.db.credentials.Credent
import com.ikigai.rideshare.db.credentials.CredentialViewModel
import com.ikigai.rideshare.db.user.User
import com.ikigai.rideshare.db.user.UserViewModel
import kotlinx.android.synthetic.main.fragment_sign_up.*
import kotlinx.android.synthetic.main.fragment_sign_up.view.*

class SignUpFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var credentialViewModel: CredentialViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)

        userViewModel =  ViewModelProvider(this).get(UserViewModel::class.java)
        credentialViewModel =  ViewModelProvider(this).get(CredentialViewModel::class.java)

        view.signup.setOnClickListener {
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {
        val firstName = fname.text.toString()
        val lastName = lname.text.toString()
        val telephone = pnumber.text.toString()
        val email = email.text.toString()
        val password = pword.text.toString()

        if (inputCheck(firstName, lastName, telephone, email, password)) {
            val user = User(0, firstName, lastName, telephone, email, password)
            val credential = Credent(0,email, password)
            userViewModel.addUser(user)
            credentialViewModel.addCredential(credential)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            // Navigate Back
            findNavController().navigate(R.id.action_signUpFragment_to_homeFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String, telephone: String, email: String,
        password: String
    ): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName)
                && TextUtils.isEmpty(telephone) && TextUtils.isEmpty(email)
                && TextUtils.isEmpty(password))
    }
}