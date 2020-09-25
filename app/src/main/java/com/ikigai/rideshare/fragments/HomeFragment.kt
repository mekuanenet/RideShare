package com.ikigai.rideshare.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.ikigai.rideshare.R
import com.ikigai.rideshare.db.user.User
import com.ikigai.rideshare.db.user.UserViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlin.math.log

class HomeFragment : Fragment(), View.OnClickListener {

    //    private lateinit var userViewModel: UserViewModel
//    private val userViewModel: UserViewModel by activityViewModels()
    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.createAccount).setOnClickListener(this)
        view.findViewById<Button>(R.id.signIn).setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if(v!!.id ==  R.id.signIn) {
            navController!!.navigate(R.id.action_homeFragment_to_profileFragment)
//            val userName: String = userName.text.toString()
//            val password: String = password.text.toString()
//            val adapter = UserAdapter()
//            var userList: List<User> = adapter.getData()
//
//            for(user in userList){
//                if(user.email == userName){
//                    if(user.password != password)
//                        Toast.makeText(v.context, "Password is incorrect", Toast.LENGTH_LONG).show()
//                    else
//                        navController!!.navigate(R.id.action_homeFragment_to_profileFragment)
//                }
//                if(user.email != userName)
//                    Toast.makeText(v.context, "We can't find your username in our database. Please register!", Toast.LENGTH_LONG).show()
//            }
        } else
            navController!!.navigate(R.id.action_homeFragment_to_signUpFragment)


    }

//        when(v!!.id){
//            R.id.createAccount -> navController!!.navigate(R.id.action_homeFragment_to_signUpFragment)
//            R.id.signIn -> {
//                val userName: String = userName.text.toString()
//                val password: String = password.text.toString()
//                var userList: List<User> = userViewModel.readAllData
//
//                for(user in userList){
//                    if(user.email == userName){
//                        if(user.password != password)
//                            Toast.makeText(v.context, "Password is incorrect", Toast.LENGTH_LONG).show()
//                        else
//                            navController!!.navigate(R.id.action_homeFragment_to_profileFragment)
//                    }
//                    if(user.email != userName)
//                        Toast.makeText(v.context, "We can't find your username in our database. Please register!", Toast.LENGTH_LONG).show()
//                }
//            }
//        }
}

//    private fun checkUser(view: View) {
//        val userName: String = view.userName.text.toString()
//        val password: String = view.password.text.toString()
//        var userList: List<User> = userViewModel.readAllData
//
//        for(user in userList){
//            if(user.email == userName){
//                if(user.password != password)
//                    Toast.makeText(view.context, "Password is incorrect", Toast.LENGTH_LONG).show()
//                else
//                    navController!!.navigate(R.id.action_homeFragment_to_profileFragment)
//            }
//            if(user.email != userName)
//                Toast.makeText(view.context, "We can't find your username in our database. Please register!", Toast.LENGTH_LONG).show()
//        }
//    }



//private fun composeEmail(addresses: Array<String>, subject: String,message:String) {
//    val intent = Intent(Intent.ACTION_SENDTO).apply {
//        data = Uri.parse("mailto:") // only email apps should handle this
//        putExtra(Intent.EXTRA_EMAIL, addresses)
//        putExtra(Intent.EXTRA_SUBJECT, subject)
//        putExtra(Intent.EXTRA_TEXT, message)
//        //setType("message/rfc822")
//    }
//    if (intent.resolveActivity(packageManager) != null) {
//        startActivity(intent)
//    }
//}
//fun composeEmail(view: View) {
//    val address=Array(1){userName.text.toString()}
//    var found=false
//    lateinit var pw: String
//    for(user in users){
//        if(user.username == userName.text.toString()) {
//            pw=user.password
//            found=true
//            break
//        }
//    }
//    var message:String
//    message = if (!found) {
//        "You don't have account with this email."
//    } else "your password is $pw without single quotes."
//    composeEmail(address,"Your forgotten password",message)
//}