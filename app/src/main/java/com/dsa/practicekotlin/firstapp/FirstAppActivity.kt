package com.dsa.practicekotlin.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dsa.practicekotlin.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)
    }
}