package com.yosiefgobeze.assignment_5_2

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.yosiefgobeze.assignment_5_2.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val users=ArrayList<User>(
        arrayListOf(
            User("Yosief", "Gobeze", "yosiefgobeze@gmail.com","123456"),
            User("Solomon","Brhane","solomon@gmail.com","123456"),
            User("Minas","Fshaye","minas@gmail.com","123456") ,
            User("Noah","Dawit","noah@gmail.com","123456"),
            User("Abraham","Tekle","abraham@gmail.com","123456")
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun OnSignIn(view: View) {
        //check if the username and password is correct
        val userName=etUserName.text.toString().trim()
        val password=etPassword.text.toString().trim()
        lateinit var currentUser:User
        var authenticatedUser:Boolean=false
        //check if the username and password is not blank
        if (userName.isNullOrBlank() || password.isNullOrBlank()){
            Toast.makeText(this,"UserName or password is required",Toast.LENGTH_LONG).show()
        }else
        {
            //check if both the username and password are presented in the arraylist

            for(u in users){
                currentUser=u
                if(u.userName.equals(userName) && u.password.equals(password)){
                    authenticatedUser=true
                    val intent= Intent(this@MainActivity,Shopping_activity::class.java)
                   // intent.putExtra("User",currentUser)
                    intent.putExtra("User",currentUser)
                    startActivity(intent)
                }
            }
            if (!authenticatedUser){
                Toast.makeText(this,"UserName or password is incorrect",Toast.LENGTH_LONG).show()
            }

        }
    }

    fun onCreateNewAccount(view: View) {
        val intent = Intent(this@MainActivity, RegisterActivity::class.java)
        startActivityForResult(intent, 1) // Here 1 is the request code
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val returnedResult = data!!.getSerializableExtra("user")!! as User
                //add the returnedResult to the ArrayList
                if(returnedResult!=null){
                    users.add(returnedResult)
                    Toast.makeText(this,"New user sucessfully added with Email : ${returnedResult.userName}",Toast.LENGTH_LONG).show()
                }

            }
        }
    }

    fun onForgotPassword(view: View) {
        val userName=etUserName.text.toString().trim()
        var isEmailPresent:Boolean=false
        lateinit var currentUser:User
        if (userName!=null){
            for(u in users){
                currentUser=u
                if(u.userName.equals(userName) ){
                    isEmailPresent=true
                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.type = "text/plain"
                    intent.putExtra(Intent.EXTRA_TEXT,"Your password is: ${u.password}")
                    startActivity(intent)
                    break
                }
            }
            if (!isEmailPresent){
                Toast.makeText(this,"Invalid Email address.",Toast.LENGTH_LONG).show()
            }

        }else
        {
            Toast.makeText(this,"Please provide your email address.",Toast.LENGTH_LONG).show()
        }

    }

}
