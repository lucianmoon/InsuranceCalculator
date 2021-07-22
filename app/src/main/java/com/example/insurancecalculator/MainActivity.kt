package com.example.insurancecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.insurancecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.buttonCalculate.setOnClickListener{
            val age= binding.spinnerAge.selectedItemPosition
            var premiumAge= 0
            when (age){
                0 -> premiumAge=60
                1 -> premiumAge=70
                2 -> premiumAge=90
                3 -> premiumAge=120
                4 -> premiumAge=150
                else -> premiumAge = 150
            }
            val basicpremium = when (age){
                0 -> 60
                1 -> 70
                2 -> 90
                3 -> 120
                4 -> 150
                else -> 0
            }
            val gender = binding.RadioGroupGender.checkedRadioButtonId
            if (gender == binding.radioButtonMale.id){
                when(age){
                    1 -> premiumAge += 50
                    2 -> premiumAge += 100
                    3 -> premiumAge += 150
                    4,5 -> premiumAge += 200
                    else -> premiumAge += 0
                }
            }
            val smokerCheck = binding.checkBoxSmoker.isChecked
            if (smokerCheck){
                if (gender == binding.radioButtonMale.id){
                    when(age){
                        1 -> premiumAge += 100
                        2 -> premiumAge += 150
                        3 -> premiumAge += 200
                        4 -> premiumAge += 250
                        5 -> premiumAge += 300
                        else -> premiumAge += 0
                    }
                }
            }
            binding.textViewPremium.text=premiumAge.toString()
            /*binding.textViewPremium.text = String.format("%d", premiumAge)
            binding.textViewPremium.text = "Premium=$premiumAge"*/
        }
        binding.buttonReset.setOnClickListener{
            binding.spinnerAge.setSelection(0)
            binding.radioButtonMale.isSelected=false
            binding.radioButtonFemale.isSelected=false
            binding.checkBoxSmoker.isChecked=false
            binding.editTextTextPersonName.setText(" ")
        }
    }
}