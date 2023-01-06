package com.example.asssignmet_all

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_loginscreen.*
import kotlinx.android.synthetic.main.activity_register.*

class register : AppCompatActivity() {

    lateinit var btnadddata: Button
    lateinit var txtname: EditText
    lateinit var txtemail: EditText
    lateinit var txtpass: EditText
    lateinit var btnview : Button
    lateinit var txtadj : TextView

    @SuppressLint("Range", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

//        txtadj = findViewById(R.id.dj)
//        registerForContextMenu(txtadj)
        btnadddata = findViewById(R.id.Adddata)
        txtemail = findViewById(R.id.u_email)
        txtname = findViewById(R.id.u_name)
        txtpass = findViewById(R.id.u_password)
        btnview = findViewById(R.id.views)

        btnadddata.setOnClickListener {

            val db = DBHelerlogin(this, null)

            val name = txtname.text.toString()
            val email = txtemail.text.toString()
            val password = txtpass.text.toString()

            db.addNames(name, email, password)

            Toast.makeText(this, name + " added to database", Toast.LENGTH_LONG).show()

            txtname.text.clear()
            txtemail.text.clear()
            txtpass.text.clear()

            val intent = Intent(this, loginscreen::class.java)
            startActivity(intent)




            """*****"""

//            val cursor = db.getName()
//
//
//            cursor!!.moveToFirst()
//            txtname.append(cursor.getString(cursor.getColumnIndex(DBHelerlogin.NAME_COl)) + "\n")
//            txtemail.append(cursor.getString(cursor.getColumnIndex(DBHelerlogin.EMAIL_COL)) + "\n")
//            txtpass.append(cursor.getString(cursor.getColumnIndex(DBHelerlogin.PASS_COL)) + "\n")
//
//            var a = txtname.text.toString()
//            var b = txtemail.text.toString()
//            var c = txtpass.text.toString()
//
//            var preference: SharedPreferences = getSharedPreferences("mypres", Context.MODE_PRIVATE)
//            var editor: SharedPreferences.Editor = preference.edit()
//            editor.putString("e_name", a)
//            editor.putString("e_email", b)
//            editor.putString("e_password", c)
//            editor.apply()
//
//            val intent = Intent(this, loginscreen::class.java)
//            startActivity(intent)
//
//
//
//            while (cursor.moveToNext()) {
//                txtname.append(cursor.getString(cursor.getColumnIndex(DBHelerlogin.NAME_COl)) + "\n")
//                txtemail.append(cursor.getString(cursor.getColumnIndex(DBHelerlogin.EMAIL_COL)) + "\n")
//                txtpass.append(cursor.getString(cursor.getColumnIndex(DBHelerlogin.PASS_COL)) + "\n")
//            }
//
//            cursor.close()




            """******"""
        }

        views.setOnClickListener {
            val intent = Intent(this, loginscreen::class.java)
              startActivity(intent)
        }





//        btnview.setOnClickListener{
//
//            val db = DBHelerlogin(this, null)
//
//            val cursor = db.getName()
//
//
//            cursor!!.moveToFirst()
//            txtname.append(cursor.getString(cursor.getColumnIndex(DBHelerlogin.NAME_COl)) + "\n")
//            txtemail.append(cursor.getString(cursor.getColumnIndex(DBHelerlogin.EMAIL_COL)) + "\n")
//            txtpass.append(cursor.getString(cursor.getColumnIndex(DBHelerlogin.PASS_COL)) + "\n")
//
//            var a =txtname.text.toString()
//            var b =txtemail.text.toString()
//            var c =txtpass.text.toString()
//
//            var preference: SharedPreferences =getSharedPreferences("mypres", Context.MODE_PRIVATE)
//            var editor: SharedPreferences.Editor=preference.edit()
//            editor.putString("e_name",a)
//            editor.putString("e_email",b)
//            editor.putString("e_password",c)
//            editor.apply()
//
//            val intent = Intent(this, loginscreen::class.java)
//            startActivity(intent)
//
//
//
//            while(cursor.moveToNext()){
//                txtname.append(cursor.getString(cursor.getColumnIndex(DBHelerlogin.NAME_COl)) + "\n")
//                txtemail.append(cursor.getString(cursor.getColumnIndex(DBHelerlogin.EMAIL_COL)) + "\n")
//                txtpass.append(cursor.getString(cursor.getColumnIndex(DBHelerlogin.PASS_COL)) + "\n")
//            }
//
//            cursor.close()
//        }
//
//
//
//    }


//    override fun onCreateContextMenu(
//        menu: ContextMenu?,
//        v: View?,
//        menuInfo: ContextMenu.ContextMenuInfo?
//    ) {
//
//        menuInflater.inflate(R.menu.menulogin, menu)
//        super.onCreateContextMenu(menu, v, menuInfo)
//
//    }

//    override fun onContextItemSelected(item: MenuItem): Boolean {
//
//
//        return when(item.itemId) {
//             R.id.first -> {
//                Toast.makeText(applicationContext, "login", Toast.LENGTH_LONG).show()
//               true
//           }
//            R.id.secod ->{
//                Toast.makeText(applicationContext,"setting",Toast.LENGTH_LONG).show()
//               true
//            }
//
//           else -> {
//               Toast.makeText(applicationContext,"theme",Toast.LENGTH_LONG).show()
//               true
//
//           }
//       }
//    }


//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//
//        menuInflater.inflate(R.menu.menulogin, menu)
//
//
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//
//        return when(item.itemId) {
//            R.id.first -> {
//                Toast.makeText(applicationContext, "login", Toast.LENGTH_LONG).show()
//                true
//            }
//            R.id.secod ->{
//                Toast.makeText(applicationContext,"setting",Toast.LENGTH_LONG).show()
//                true
//            }
//
//            else -> {
//                Toast.makeText(applicationContext,"theme",Toast.LENGTH_LONG).show()
//                true
//
//            }
//        }
//    }


    }
}