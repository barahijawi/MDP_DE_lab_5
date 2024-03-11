package com.example.lab5

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lab5.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startSurveyButton.setOnClickListener {
            val selectedSurveyTypeId = binding.radioGroupSurveyType.checkedRadioButtonId
            val surveyType = when (selectedSurveyTypeId) {
                R.id.radioFoodPreferences -> "FoodPreferences"
                R.id.radioDietaryHabits -> "DietaryHabits"
                else -> ""
            }
            startSurvey(surveyType)
        }
    }

    private fun startSurvey(surveyType: String) {
        if (surveyType.isNotEmpty()) {
            val intent = Intent(this, SurveyActivity::class.java).apply {
                putExtra("surveyType", surveyType)
            }
            startActivity(intent)
        } else {
            Toast.makeText(this, "Please select one survey", Toast.LENGTH_SHORT).show()

        }
    }
}