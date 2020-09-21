package com.ikigai.rideshare.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ikigai.rideshare.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun signUp(view: View) {}

    fun createAccount(view: View) {
        val intent= Intent(this, CreateAccount::class.java)
        startActivity(intent)
    }


}