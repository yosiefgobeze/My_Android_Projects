package com.yosiefgobeze.assignment_6

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*
import java.time.LocalDateTime as LocalDateTime1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onSubmit(view: View) {
        var result:Int = 0
        var Quiz1Sol=findViewById<RadioButton>(R.id.quiz_one_rb_one)
        var Quiz2Sol1=findViewById<CheckBox>( R.id.quiz_two_ch_one)
        var Quiz2Sol2=findViewById<CheckBox>(R.id.quiz_two_ch_two)
        var Quiz2Sol3= findViewById<CheckBox>( R.id.quiz_two_ch_three)


        val dateTime = LocalDateTime1.now()
        val currentDateTime =dateTime.format(DateTimeFormatter.ofPattern("MM/dd/yyyy H:m:ss"))
        if(Quiz1Sol.isChecked){
            result += 50
        }
        if(Quiz2Sol3.isChecked){
            if (!Quiz2Sol1.isChecked && !Quiz2Sol2.isChecked)
                result += 50
        }

        val builder=AlertDialog.Builder(this)
        builder.setTitle("Your result is:")
        builder.setMessage("Congratulations! You submitted on $currentDateTime, Your achieved $result%")
        builder.setPositiveButton("Ok"){dialog, which ->
            dialog.dismiss()
        }
        var dialog: AlertDialog=builder.create()
        dialog.show()
    }
    fun onReset(view: View) {
        rgQuestion1.clearCheck()
        quiz_two_ch_one.isChecked=false
        quiz_two_ch_two.isChecked=false
        quiz_two_ch_three.isChecked=false

    }
}
