package com.yosiefgobeze.assignment_5_2

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.yosiefgobeze.assignment_5_2.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun OnCreateNewAccount(view: View) {
        val data = Intent()
        val user = User(etFirstName.text.toString(),etLastName.text.toString(),etEmail.text.toString(),etPassword.text.toString())
        //---set the data to pass back
        data.putExtra("user", user)
        setResult(Activity.RESULT_OK, data)
        //---close the activity---
        finish()
    }
}
