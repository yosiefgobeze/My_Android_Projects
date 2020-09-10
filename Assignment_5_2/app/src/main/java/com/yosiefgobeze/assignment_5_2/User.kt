package com.yosiefgobeze.assignment_5_2

import java.io.Serializable

data class User(var firstName:String,var lastName:String,val userName:String,var password:String ):
    Serializable {
}