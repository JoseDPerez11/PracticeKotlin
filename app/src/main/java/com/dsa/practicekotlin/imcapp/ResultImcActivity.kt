package com.dsa.practicekotlin.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.dsa.practicekotlin.R
import com.dsa.practicekotlin.databinding.ActivityResultBinding
import com.dsa.practicekotlin.databinding.ActivityResultImcBinding
import com.dsa.practicekotlin.imcapp.ImcAppActivity.Companion.KEY_IMC

class ResultImcActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultImcBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultImcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result: Double = intent.extras?.getDouble(KEY_IMC) ?: -1.0

        initUI(result)
        initListeners()
    }

    private fun initUI(result: Double) {
        binding.tvImc.text = result.toString()

        when(result) {
            in 0.00..18.50 -> { //Bajo peso
                binding.tvResult.text = getString(R.string.title_bajo_peso)
                binding.tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
                binding.tvDescription.text = getString(R.string.description_bajo_peso)
            }
            in 18.51..24.99 -> { //Peso normal
                binding.tvResult.text = getString(R.string.title_peso_normal)
                binding.tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))
                binding.tvDescription.text = getString(R.string.description_peso_normal)
            }
            in 25.00..29.99 -> { //Sobrepeso
                binding.tvResult.text = getString(R.string.title_sobrepeso)
                binding.tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_sobrepeso))
                binding.tvDescription.text = getString(R.string.description_sobrepeso)
            }
            in 30.00..99.00 -> { //Obesidad
                binding.tvResult.text = getString(R.string.title_obesidad)
                binding.tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                binding.tvDescription.text = getString(R.string.description_obesidad)
            }
            else -> {//error
                binding.tvImc.text = getString(R.string.error)
                binding.tvResult.text = getString(R.string.error)
                binding.tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                binding.tvDescription.text = getString(R.string.error)
            }
        }

    }

    private fun initListeners() {
        binding.btnRecalculate.setOnClickListener{ onBackPressed() }
    }

}