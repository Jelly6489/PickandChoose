package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Instart : Basics() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.instart)
    }

    override fun onBackPressed() {
        startActivity(Intent(this@Instart, InPhon ::class.java))
    }
}