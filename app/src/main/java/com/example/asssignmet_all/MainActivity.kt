package com.example.asssignmet_all

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var img: ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img=findViewById(R.id.ztbimg)


        img.alpha = 0f
        img.animate().setDuration(1500).alpha(1f).withEndAction{
            var preferences: SharedPreferences =getSharedPreferences("mypre", Context.MODE_PRIVATE)
            var uname=preferences.getString("e_email","")
            if (uname!=null && !uname.equals("")) {
                var intent = Intent(applicationContext, navigation::class.java)
                startActivity(intent)
                finish()
            }
            else
            {
                var intent = Intent(applicationContext, loginscreen::class.java)
                startActivity(intent)
            }
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()


        }








    }
}