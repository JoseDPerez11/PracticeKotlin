package com.dsa.practicekotlin.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.dsa.practicekotlin.R
import com.dsa.practicekotlin.databinding.ActivityImcAppBinding
import com.dsa.practicekotlin.imcapp.ImcAppActivity.Companion.KEY_IMC
import java.text.DecimalFormat

class ImcAppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImcAppBinding

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentHeight: Int = 120
    private var currentWeight: Int = 70
    private var currentAge: Int = 20

    companion object {
        const val KEY_IMC = "keyimc"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImcAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
        initUI()

    }

    private fun initListeners() {

        binding.viewMale.setOnClickListener{
            changeGender()
            setGenderColor()
        }
        binding.viewFemale.setOnClickListener{
            changeGender()
            setGenderColor()
        }

        binding.rsHeight.addOnChangeListener {_, value, _ ->
            val df = DecimalFormat("#.##")
            currentHeight= df.format(value).toInt()
            binding.tvHeight.text = "$currentHeight cm"
        }

        binding.btnPlusWeight.setOnClickListener{
            currentWeight += 1
            setWeight()
        }
        binding.btnSubtractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }

        binding.btnPlusAge.setOnClickListener{
            currentAge += 1
            setAge()
        }
        binding.btnSubtractAge.setOnClickListener{
            currentAge -= 1
            setAge()
        }

        binding.btnCalculate.setOnClickListener{
            val result = calculateIMC()
            navigateToResultImc(result)
        }
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {
        binding.viewMale.setCardBackgroundColor( getBackgroundColor(isMaleSelected) )
        binding.viewFemale.setCardBackgroundColor( getBackgroundColor(isFemaleSelected) )
    }

    private fun getBackgroundColor(value: Boolean): Int {
        val colorReference = if (value) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }

    private fun setWeight() {
        binding.tvWeight.text = currentWeight.toString()
    }

    private fun setAge() {
        binding.tvAge.text = currentAge.toString()
    }

    private fun calculateIMC(): Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeight.toDouble()/100 * currentHeight.toDouble()/100)
        return df.format(imc).toDouble()
    }

    private fun navigateToResultImc(resultImc: Double) {
        val intent = Intent(this, ResultImcActivity::class.java)
        intent.putExtra(KEY_IMC, resultImc)
        startActivity(intent)
    }

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }

}