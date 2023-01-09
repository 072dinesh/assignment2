package com.example.asssignmet_all

import android.annotation.SuppressLint
import android.app.Application
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
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME)
        onCreate(db)
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

    @SuppressLint("Range")
    fun getOneName(name: String): Companion? {
        val db = this.writableDatabase
        val selectQuery = "SELECT  NAME FROM $TABLE_NAME WHERE $EMAIL_COL = ?"
        db.rawQuery(selectQuery, arrayOf(name)).use { // .use requires API 16
            if (it.moveToFirst()) {
                val result = DBHelerlogin
                //result.ID_COL = it.getInt(it.getColumnIndex(ID_COL)).toString()
                result.NAME_COl = it.getString(it.getColumnIndex(NAME_COl))
                return result
            }
        }
        return null
    }

    companion object{

        private val DATABASE_NAME = "student"
        private val DATABASE_VERSION = 1

        val TABLE_NAME = "stdss"
        var ID_COL = "id"
        var NAME_COl = "name"
        val EMAIL_COL = "email"
        val PASS_COL ="passwords"
    }
}