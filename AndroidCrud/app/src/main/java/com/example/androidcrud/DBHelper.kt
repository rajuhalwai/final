package com.example.androidcrud

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DBHelper(context: Context)  : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){
    companion object {
        const val DATABASE_NAME = "mydatabase.db"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "users"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_CITY = "city"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        val createTableSQL = """
         CREATE TABLE $TABLE_NAME (
         $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
         $COLUMN_NAME TEXT,
         $COLUMN_CITY TEXT
     )
    """.trimIndent()
        db?.execSQL(createTableSQL)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
    // Insert record
    fun insertRecord(name: String, city: String): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, name)
            put(COLUMN_CITY, city)
        }
        return db.insert(TABLE_NAME, null, values)
    }
    // Update record
    fun updateRecord(id: Int, name: String, city: String): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, name)
            put(COLUMN_CITY, city)
        }
        return db.update(TABLE_NAME, values, "$COLUMN_ID = ?", arrayOf(id.toString()))
    }
    // Select all records
    fun getAllRecords(): Cursor {
        val db = readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }
    // Delete record by ID
    fun deleteRecord(id: Int): Int {
        val db = writableDatabase
        return db.delete(TABLE_NAME, "$COLUMN_ID = ?", arrayOf(id.toString()))
    }
}