package com.example.asssignmet_all

import android.annotation.SuppressLint
import android.content.Intent
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
            var intent= Intent(applicationContext, loginscreen::class.java)
            startActivity(intent)

            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()


        }







    }
}