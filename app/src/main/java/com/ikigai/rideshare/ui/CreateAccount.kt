package com.ikigai.rideshare

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class CreateAccount : AppCompatActivity(){
    lateinit var fmanager: FragmentManager
    lateinit var tx: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.account_create)

        fmanager = supportFragmentManager
        tx = fmanager.beginTransaction()
        tx.add(R.id.frame1, TravelerFragment())
        tx.commit()
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
}