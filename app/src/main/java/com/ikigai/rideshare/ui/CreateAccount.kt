package com.ikigai.rideshare.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.room.Room
import com.ikigai.rideshare.R
import com.ikigai.rideshare.db.User
import com.ikigai.rideshare.db.UserDao
import com.ikigai.rideshare.db.UserDataBase


class CreateAccount : AppCompatActivity(){
    lateinit var fmanager: FragmentManager
    lateinit var tx: FragmentTransaction

    private var userDao: UserDao? = null


    var firstName: EditText? = null
    var lastName: EditText? = null
    var phoneNum: EditText? = null
    var editTextEmail:EditText? = null
    var vehicleNum:EditText? = null
    var editTextCnfPassword:EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.account_create)

        fmanager = supportFragmentManager
        tx = fmanager.beginTransaction()
        tx.add(R.id.frame1, TravelerFragment())
        tx.commit()

        userDao =
            Room.databaseBuilder(this, UserDataBase::class.java, "mi-database.db")
                .allowMainThreadQueries()
                .build().userDao
    }

    fun traveler(view: View) {
        tx = fmanager.beginTransaction()
        tx.replace(R.id.frame1, TravelerFragment())
        tx.commit()
    }
    fun rider(view: View) {
        tx = fmanager.beginTransaction()
        tx.replace(R.id.frame1, RiderFragment())
        tx.commit()
    }

    fun saveUser(view: View){
        firstName = findViewById(R.id.fname)
        lastName = findViewById(R.id.lname)
        phoneNum = findViewById(R.id.pnumber)
        editTextEmail = findViewById(R.id.email)
        vehicleNum = findViewById(R.id.vehicle_type)
        editTextCnfPassword = findViewById(R.id.pword)

        val fName: String = firstName?.text.toString().trim()
        val lName: String = lastName?.text.toString().trim()
        val pnum: String = phoneNum?.text.toString().trim()
        val mail: String = editTextEmail?.text.toString().trim()
        val vhicle: String = vehicleNum?.text.toString().trim()
        val pword: String = editTextCnfPassword?.text.toString().trim()

        val user: User? = User(fName,lName,pnum,mail,pword)

        if(user!=null){
            userDao?.insert(user)
            val moveToLogin = Intent(this, MainActivity::class.java)
            startActivity(moveToLogin)
            finish()
        }else{
            Toast.makeText(
                this,
                "Wrong input!! Try again",
                Toast.LENGTH_SHORT
            ).show()
        }

    }
}