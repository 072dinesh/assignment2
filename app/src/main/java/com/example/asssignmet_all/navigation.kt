package com.example.asssignmet_all

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_dashboardscreen.*
import kotlinx.android.synthetic.main.activity_navigation.*
import kotlinx.android.synthetic.main.nevhead.*

class navigation : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drew:DrawerLayout
    lateinit var naviga : NavigationView
    lateinit var cursor:Cursor
    @SuppressLint("MissingInflatedId", "Range")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        var preference: SharedPreferences =getSharedPreferences("mypres", Context.MODE_PRIVATE)
        var savestring2 = preference.getString("e_email","")




        naviga=findViewById(R.id.navview)
        var a = naviga.inflateHeaderView(R.layout.nevhead)
        var viewa = a.findViewById<TextView>(R.id.hhid)

        viewa.text = savestring2
        //viewa.text = helper
//
//            val db = DBHelerlogin(this, null)
//            var name:String
//            val cursor = db.getName()
//
//            cursor!!.moveToFirst()
//        hhid.append(cursor.getString(cursor.getColumnIndex(DBHelerlogin.NAME_COl)) + "\n")








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
        if(item.itemId==R.id.first)
        {
            var preference: SharedPreferences = getSharedPreferences("mypres", Context.MODE_PRIVATE)
          var editor: SharedPreferences.Editor = preference.edit()
            editor.clear()
            editor.commit()
            var intent = Intent(applicationContext, loginscreen::class.java)
            startActivity(intent)
        }


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