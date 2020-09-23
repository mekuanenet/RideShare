package com.ikigai.rideshare.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.format.DateFormat
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ikigai.rideshare.R
import com.ikigai.rideshare.db.trip.Trip
import com.ikigai.rideshare.db.trip.TripViewModel
import kotlinx.android.synthetic.main.activity_trip.*
import java.util.*


class TripActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener {

    private lateinit var tripViewModel: TripViewModel

    //For datepicker
    var day = 0
    var month: Int = 0
    var year: Int = 0
    var hour: Int = 0
    var minute: Int = 0
    var myDate: String = ""
    var myTime: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip)

        tripViewModel = ViewModelProvider(this).get(TripViewModel::class.java)
    }

    fun insertDataToDatabase(view: View) {
        val from = from_et.text.toString()
        val to = to_et.text.toString()
        val date = myDate
        val time = myTime
        val traveler = traveler_et.text
        val message = message_et.text.toString()

        if(inputCheck(from, to, date, time, traveler, message)) {
            val trip = Trip(0, from, to, date, time, Integer.parseInt(traveler.toString()), message)
            tripViewModel.addTrip(trip)
            Toast.makeText(this, "Successfully added!", Toast.LENGTH_LONG).show()
        }
    }

    fun inputCheck(
        from: String, to: String, date: String, time: String,
        traveler: Editable, message: String
    ): Boolean {
        return !(TextUtils.isEmpty(from) && TextUtils.isEmpty(to)
                && TextUtils.isEmpty(date) && TextUtils.isEmpty(time)
                && TextUtils.isEmpty(traveler) && TextUtils.isEmpty(message))
    }

    fun displayDatePicker(view: View) {
        val calendar: Calendar = Calendar.getInstance()
        day = calendar.get(Calendar.DAY_OF_MONTH)
        month = calendar.get(Calendar.MONTH)
        year = calendar.get(Calendar.YEAR)
        val datePickerDialog =
            DatePickerDialog(this@TripActivity, this@TripActivity, year, month,day)
        datePickerDialog.show()
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        myDate = month.toString() + "/" + day.toString() + "/" + year.toString()
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        myTime = hourOfDay.toString() + " : " + minute.toString()
    }

    fun displayTimePicker(view: View) {
        val calendar: Calendar = Calendar.getInstance()
        hour = calendar.get(Calendar.HOUR)
        minute = calendar.get(Calendar.MINUTE)
        val timePickerDialog = TimePickerDialog(this@TripActivity, this@TripActivity, hour, minute,
            DateFormat.is24HourFormat(this))
        timePickerDialog.show()
    }
}