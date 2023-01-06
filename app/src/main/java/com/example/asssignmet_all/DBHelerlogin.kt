package com.example.asssignmet_all

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast


import java.security.KeyFactory

class DBHelerlogin(context: Context,fac:SQLiteDatabase.CursorFactory?): SQLiteOpenHelper(context,DATABASE_NAME,fac,DATABASE_VERSION)
{
    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE $TABLE_NAME ($ID_COL integer primary key autoincrement, $NAME_COl TEXT,$EMAIL_COL TEXT,$PASS_COL TEXT)")


        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        //db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME)
        //onCreate(db)
    }
   open fun addNames(name : String, email : String, password : String ){


        val valuess = ContentValues()

        valuess.put(NAME_COl,name)
        valuess.put(EMAIL_COL,email)
        valuess.put(PASS_COL,password)

        val db = this.writableDatabase

        db.insert(TABLE_NAME, null, valuess)

        db.close()
    }

    fun getName(): Cursor? {

        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null)

    }

    companion object{

        private val DATABASE_NAME = "student"
        private val DATABASE_VERSION = 1

        val TABLE_NAME = "stdss"
        val ID_COL = "id"
        val NAME_COl = "name"
        val EMAIL_COL = "email"
        val PASS_COL ="passwords"
    }
}