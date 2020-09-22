package com.ikigai.rideshare.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.ikigai.rideshare.R
import com.ikigai.rideshare.db.UserDao
import com.ikigai.rideshare.db.UserDataBase


class MainActivity : AppCompatActivity() {
    var editTextEmail: EditText? = null
    var editTextPassword:EditText? = null
    var db:UserDao? = null
    var dataBase: UserDataBase? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextEmail = findViewById(R.id.userName)
        editTextPassword = findViewById(R.id.password)

        dataBase =
            Room.databaseBuilder(this, UserDataBase::class.java, "mi-database.db")
                .allowMainThreadQueries()
                .build()

        db = dataBase!!.userDao
    }


    fun signingIn(view: View) {
        val email: String = editTextEmail?.text.toString().trim()
        val password: String = editTextPassword?.text.toString().trim()

        val user = db!!.getUser(email, password)

        if (user != null) {
            val i = Intent(this@MainActivity, CreateAccount::class.java)
            i.putExtra("User", user)
            startActivity(i)
            finish()
        } else {
            Toast.makeText(
                this@MainActivity,
                "Wrong username or password",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun createAccount(view: View) {
        val intent= Intent(this, CreateAccount::class.java)
        startActivity(intent)
    }


}