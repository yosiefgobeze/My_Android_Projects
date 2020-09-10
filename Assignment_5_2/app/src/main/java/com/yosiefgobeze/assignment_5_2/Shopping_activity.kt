package com.yosiefgobeze.assignment_5_2


import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.yosiefgobeze.assignment_5_2.R
import kotlinx.android.synthetic.main.activity_shopping_activity.*

class Shopping_activity : AppCompatActivity() {
    lateinit var currentUser :User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_activity)

        //var adapter=ArrayAdapter<>

        val intent= intent
        var temp=intent.getSerializableExtra("User")
        currentUser=temp as User
        tvLoginHistory.text="Hello " + currentUser.userName



    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun OnImageClick(view: View) {
       val result=when (view.id){
           R.id.ivElectronics->"Electronics"
           R.id.ivClothing->"Clothing"
           R.id.ivBeauty->"Beauty"
           R.id.ivFood->"Food"
           else->"Not Selected"
       }

        val intent= Intent(this,CategoryList::class.java)
        // intent.putExtra("User",currentUser)
        intent.putExtra("Category",result)
        startActivity(intent)

        //Toast.makeText(this,"You have chosen the $result category of shopping",Toast.LENGTH_LONG).show()
    }


}
