package com.dsa.practicekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dsa.practicekotlin.databinding.ActivityMenuBinding
import com.dsa.practicekotlin.firstapp.FirstAppActivity
import com.dsa.practicekotlin.imcapp.ImcAppActivity
import com.dsa.practicekotlin.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSaludApp.setOnClickListener{ navigateToSaludarApp() }
        binding.btnImcApp.setOnClickListener{ navigateToImcApp() }
        binding.btnTodoApp.setOnClickListener{ navigateToTodoApp() }

    }

    private fun navigateToSaludarApp() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToImcApp() {
        val intent = Intent(this, ImcAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToTodoApp() {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }

}