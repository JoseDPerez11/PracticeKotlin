package com.dsa.practicekotlin.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dsa.practicekotlin.R
import com.dsa.practicekotlin.databinding.ActivityFirstAppBinding

class FirstAppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstAppBinding

    private lateinit var student: StudentModel

    companion object {
        const val KEY_EXTRA = "keyextra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstAppBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnStart.setOnClickListener{

            val name = binding.etName.text.toString()
            val lastname = binding.etLastname.text.toString()
            val profession = binding.etProfession.text.toString()
            val research = binding.etResearch.text.toString()

            student = StudentModel(name, lastname, profession, research)

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(KEY_EXTRA, student)
            startActivity(intent)


        }

    }
}