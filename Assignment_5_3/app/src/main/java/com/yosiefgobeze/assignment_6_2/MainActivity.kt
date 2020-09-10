package com.yosiefgobeze.assignment_6_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var r1: RecyclerView?=null
    var layoutManager: RecyclerView.LayoutManager?=null
    var madr : MyAdapter?=null
    var images=intArrayOf(R.drawable.tablet1,R.drawable.labtop1,R.drawable.printer1,R.drawable.tv1)
    var productList=ArrayList<Product>(
            arrayListOf(
                    Product("101","Acer 15.6 inches",350.89,"Black",R.drawable.thinkpad.toString(),"The ThinkPad E590’s security features help your SMB take control. The optional fingerprint reader adds secure biometric authentication, while the discrete trusted platform module (TPM) encrypts data at the hardware level. We take care of security so you can take care of business.")
                    ,Product("102","APPLE iPhone 11 Pro Max",1000.25,"Midnight Green",R.drawable.iphone11.toString(),"Featuring a Stunning Pro Display, A13 Bionic, Cutting-Edge Pro Camera System and Longest Battery Life Ever in iPhone with iPhone 11 Pro Max")
                    ,Product("103","VIZIO 70\" Class 4K",489.56,"Black",R.drawable.tv2.toString(),"The Skyworth premium 1080p HD LED Television offers perfect picture quality and sound. A TV made for the future with its premium LED panel and A53 quad-core processors for both Graphics and power. Modern thin design frame design, Durable alloy with the Gilt color and Sandblasting. The infinity A53 quad-core processor")
                    ,Product("104","Canon PIXMA",300.00,"Black",R.drawable.printer2.toString(),"The Epson WorkForce WF-2750 is an all-in-one inkjet printer with scan and copy functions, an automatic document feeder and built-in faxing. It works with Windows and macOS. The capacity of the main paper tray is 150 sheets, a typical size. ... The printer has a medium-size 2.3-inch display screen.")
                    ,Product("105","Samsung Galaxy S20+",562.58,"Brown",R.drawable.sumsung.toString(),"Power of 5G: Get next-level power for everything you love to do with Samsung Galaxy 5G; Share more, game harder, experience more and never miss a beat Capture hi-res images as if you’re 3 feet away, from 100 feet away; Whether you want to zoom in close from afar or magnify details nearby, the new 30x Space Zoom gives you impressive power and clarity")
            )
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        r1 = findViewById<RecyclerView>(R.id.rv)

        madr = MyAdapter(this,productList)
        layoutManager = LinearLayoutManager(this)
        r1?.layoutManager = layoutManager
        r1?.adapter = madr
    }
}