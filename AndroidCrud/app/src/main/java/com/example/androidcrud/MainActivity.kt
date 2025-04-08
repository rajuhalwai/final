package com.example.androidcrud

import com.example.androidcrud.DBHelper
import android.annotation.SuppressLint
import android.database.Cursor
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var dbHelper: DBHelper
    private lateinit var nameEditText: EditText
    private lateinit var cityEditText: EditText
    private lateinit var idEditText: EditText
    private lateinit var insertButton: Button
    private lateinit var updateButton: Button
    private lateinit var deleteButton: Button
    private lateinit var selectButton: Button
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dbHelper = DBHelper(this)
        nameEditText = findViewById(R.id.nameEditText)
        cityEditText = findViewById(R.id.cityEditText)
        idEditText = findViewById(R.id.idEditText)
        insertButton = findViewById(R.id.insertButton)
        updateButton = findViewById(R.id.updateButton)
        deleteButton = findViewById(R.id.deleteButton)
        selectButton = findViewById(R.id.selectButton)

        // Insert record
        insertButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val city = cityEditText.text.toString()
            if (name.isNotEmpty() && city.isNotEmpty()) {
                val result = dbHelper.insertRecord(name, city)
                if (result != -1L) {
                    Toast.makeText(this, "Record inserted", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Failed to insert record", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
        // Update record
        updateButton.setOnClickListener {
            val id = idEditText.text.toString().toIntOrNull()
            val name = nameEditText.text.toString()
            val city = cityEditText.text.toString()
            if (id != null && name.isNotEmpty() && city.isNotEmpty()) {
                val result = dbHelper.updateRecord(id, name, city)
                if (result > 0) {
                    Toast.makeText(this, "Record updated", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Failed to update record", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
// Delete record
        deleteButton.setOnClickListener {
            val id = idEditText.text.toString().toIntOrNull()
            if (id != null) {
                val result = dbHelper.deleteRecord(id)
                if (result > 0) {
                    Toast.makeText(this, "Record deleted", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Failed to delete record", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter a valid ID", Toast.LENGTH_SHORT).show()
            }
        }
// Select all records
        selectButton.setOnClickListener {
            val cursor: Cursor = dbHelper.getAllRecords()
            if (cursor.moveToFirst()) {
                val result = StringBuilder()
                do {
                    val id = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_ID))
                    val name = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_NAME))
                    val city = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_CITY))
                    result.append("ID: $id, Name: $name, City: $city\n")
                } while (cursor.moveToNext())
                Toast.makeText(this, result.toString(), Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "No records found", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
