package com.namvox.baitaptuan02

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val edt_fullname = findViewById<EditText>(R.id.edt_fullName)
        val edt_book1 = findViewById<EditText>(R.id.edt_book1)
        val edt_book2 = findViewById<EditText>(R.id.edt_book2)
        val btn_change = findViewById<Button>(R.id.btn_change)
        val btn_add = findViewById<Button>(R.id.btn_add)

        btn_add.setOnClickListener{
            val employee = edt_fullname.text.toString().trim()
            val book1 = edt_book1.text.toString().trim()
            val book2 = edt_book2.text.toString().trim()
            Toast.makeText(this, "Bạn đã mượn sách $book1 và $book2 thành công - Nhân viên: $employee", Toast.LENGTH_LONG).show()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}