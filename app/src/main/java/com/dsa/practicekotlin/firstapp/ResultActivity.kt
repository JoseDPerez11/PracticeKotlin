package com.dsa.practicekotlin.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dsa.practicekotlin.databinding.ActivityResultBinding
import com.dsa.practicekotlin.firstapp.FirstAppActivity.Companion.KEY_EXTRA

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val student = intent.getSerializableExtra(KEY_EXTRA) as StudentModel

        binding.tvResult.text = "Hola, soy ${student.name} ${student.lastname}, estudio ${student.profession} " +
                "y ahora estoy investigando sobre ${student.research}"

    }
}