package com.example.asssignmet_all

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_dashboardscreen.*

class dashboardscreen : AppCompatActivity() {
        lateinit var a:TextView
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboardscreen)

        var preference: SharedPreferences =getSharedPreferences("mypres", Context.MODE_PRIVATE)
           var savestring2 = preference.getString("e_email","email")

        hid.text = savestring2
        var viewpageall = viewpagesjis//XML NAME
        var tablaouts = tabview //XML NAME

    var viewpagessd= viewpages(supportFragmentManager)
        viewpagessd.addfragment(PFragment(),"  Home")
        viewpagessd.addfragment(PFragment2(),"Vendors")
        viewpagessd.addfragment(PFragment3(),"List")
        viewpagessd.addfragment(PFragment4(),"Categories")
        viewpagessd.addfragment(PFragment5(),"More")

        viewpageall.adapter=viewpagessd
        tablaouts.setupWithViewPager(viewpageall)



    }
}