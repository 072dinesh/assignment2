package com.example.asssignmet_all

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_loginscreen.*

class loginscreen : AppCompatActivity() {
    lateinit var db : SQLiteDatabase
    lateinit var tname:EditText
    lateinit var temail:EditText
    lateinit var tpassword:EditText
   lateinit var btnlogin:Button
   lateinit var txtch : TextView



    @SuppressLint("MissingInflatedId", "Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginscreen)

        var helper = DBHelerlogin(applicationContext,null)
        db = helper.readableDatabase


        temail = findViewById(R.id.email)
        tpassword = findViewById(R.id.password)
       btnlogin = findViewById(R.id.login)
        //txtch = findViewById(R.id.cheks)

        Sin.setOnClickListener {

            var intent =  Intent(applicationContext,register::class.java)
            startActivity(intent)
        }

    btnlogin.setOnClickListener {

        login_data()
}









//        btnlogin.setOnClickListener {
//
//
//
//            tname.text.toString()
//            temail.text.toString()
//            tpassword.text.toString()
//
//
//            var preference: SharedPreferences =getSharedPreferences("mypres", Context.MODE_PRIVATE)
//            var a = preference.getString("e_name","name")
//            var savestring2 = preference.getString("e_email","email")
//            var savestring3 = preference.getString("e_password","password")
//
//
//            txtch.text = a
//
//
//
//
//            if(savestring2.equals(savestring3)){
//
//                Toast.makeText(this, "Email and Password successfully", Toast.LENGTH_LONG).show()
//
//            }
//            else
//            {
//                Toast.makeText(this, "Email and Password success not", Toast.LENGTH_LONG).show()
//
//            }
//
//        }



    }

    public fun login_data()
    {
        var p = Patterns.EMAIL_ADDRESS
        if (TextUtils.isEmpty(temail.text.toString()))
        {
            temail.setError("Please Enter The Email")
            temail.requestFocus()
        }

        else if(TextUtils.isEmpty(tpassword.text.toString()))
        {
            tpassword.setError("Enter the password")
            tpassword.requestFocus()
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(temail.text.toString()).matches()){

            temail.setError("Enter the properly")
            temail.requestFocus()
        }

        else {


            var args = listOf<String>(temail.text.toString(), tpassword.text.toString()).toTypedArray()
            var rs = db.rawQuery("SELECT * FROM stdss WHERE email = ? AND passwords = ?", args)
            if (rs.moveToNext()) {
                var preference: SharedPreferences = getSharedPreferences("mypres", Context.MODE_PRIVATE)
                var editor: SharedPreferences.Editor = preference.edit()

                editor.putString("e_email", temail.text.toString())
                editor.putString("e_password", tpassword.text.toString())
                editor.apply()
                editor.commit()



                var intent =  Intent(applicationContext,navigation::class.java)
                startActivity(intent)
                Toast.makeText(applicationContext, "recode", Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(applicationContext, "Invalid Credential", Toast.LENGTH_LONG).show()

            }
        }

    }

}