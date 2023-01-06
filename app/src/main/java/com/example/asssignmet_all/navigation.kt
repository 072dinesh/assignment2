package com.example.asssignmet_all

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_navigation.*

class navigation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        changeFragment(PFragment())
        bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId)
            {
                R.id.menu_home -> changeFragment(PFragment())
                R.id.menu_vendors -> changeFragment(PFragment2())
                R.id.menu_category -> changeFragment(PFragment3())
                R.id.menu_list -> changeFragment(PFragment4())
                R.id.menu_more -> changeFragment(PFragment5())
                else->{


                }
            }
            true

        }



    }

    private fun changeFragment(fragment : Fragment)
    {
        val fragmentmanger =  supportFragmentManager
        val fragmenttransaction =  fragmentmanger.beginTransaction()
        fragmenttransaction.replace(R.id.dash_frame,fragment)
        fragmenttransaction.commit()


    }
}