package com.example.asssignmet_all

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_navigation.*

class navigation : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drew:DrawerLayout
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        var preference: SharedPreferences =getSharedPreferences("mypres", Context.MODE_PRIVATE)
        var savestring2 = preference.getString("e_email","email")
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


        fun new()
        {

            val sharein = Intent()
            sharein.action = Intent.ACTION_SEND
            sharein.type = "text/plain"
            sharein.putExtra(
                Intent.EXTRA_TEXT,
                "https://play.google.com/store/apps/details?id= hi"
            )
            startActivity(Intent.createChooser(sharein, "Share With App..."))
        }

        fun new2()
        {
            val Email = Intent(Intent.ACTION_SEND)
            Email.type = "text/email"
            Email.putExtra(Intent.EXTRA_EMAIL, arrayOf(" "))
            Email.putExtra(Intent.EXTRA_SUBJECT, "Feedback")
            Email.putExtra(Intent.EXTRA_TEXT, "Dear ...," + "")
            startActivity(Email)

        }

        fun new3()
        {

//            val intent = Intent(this, about::class.java)
//            startActivity(intent)

            Toast.makeText(this, "Email and Password successfully", Toast.LENGTH_LONG).show()

        }

        fun new4()
        {
            Toast.makeText(this, "Email and Password successfully", Toast.LENGTH_LONG).show()
//            val intent = Intent(this, loginss::class.java)
//            startActivity(intent)
//            finish()
        }





         drew =findViewById<DrawerLayout>(R.id.drawerLayout)

        toggle= ActionBarDrawerToggle(this, drew, R.string.open,R.string.close)
        drew.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)






        var views=findViewById<NavigationView>(R.id.navview)



        views.setNavigationItemSelectedListener {


            when(it.itemId)
            {
                R.id.mitItem1->changeFragment1(paymentFragment())

                R.id.mitItem2-> changeFragment1(addressFragment())

                R.id.mitItem3-> changeFragment1(passFragment())

                R.id.mitItem5 -> changeFragment1(houseFragment())



            }



            true
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.login,menu)




        return true
    }




    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item))
        {


            return true
        }
//        if(item.itemId==R.id.mitItem1)
//        {
//
//        }


        return super.onOptionsItemSelected(item)
    }






    private fun changeFragment(fragment : Fragment)
    {
        val fragmentmanger =  supportFragmentManager
        val fragmenttransaction =  fragmentmanger.beginTransaction()
        fragmenttransaction.replace(R.id.dash_frame,fragment)
        fragmenttransaction.commit()


    }

    private fun changeFragment1(fragment : Fragment)
    {
        val fragmentmanger =  supportFragmentManager
        val fragmenttransaction =  fragmentmanger.beginTransaction()
        fragmenttransaction.replace(R.id.dash_frame,fragment)
        fragmenttransaction.commit()
        drew.closeDrawers()


    }

}