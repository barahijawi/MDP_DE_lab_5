package com.example.lab5

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding
import com.example.lab5.databinding.ActivitySurveyBinding

class SurveyActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySurveyBinding
    private val surveyResponses = mutableMapOf<String, String>()
private var numOfQuestions = 0;
    // Sample data structure for questions
    private val dietaryHabitsQuestions = mapOf(
        "Are you vegetarian?" to listOf("Yes", "No"),
        "Do you prefer organic food?" to listOf("Yes", "No"),
        "Do you consume diary products?" to listOf("Yes","No"),
        "Do you eat fast food?" to listOf("Yes","No"),
        "Do you have any food allergies?" to listOf("Yes","No"),


        )

    private val foodPreferencesQuestions = mapOf(
        "What is your favorite cuisine?" to listOf("Chinese", "French", "Italian", "Indian", "Japanese", "Thai", "Turkish"),
        "How often do you eat out?" to listOf("Never", "Rarely", "Sometimes", "Frequently"),
        "Do you prefer spicy food?" to listOf("Yes", "No"),
        "Do you prefer vegetarian food?" to listOf("Yes", "No"),
        "Do you like seafood?" to listOf("Yes", "No")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurveyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val surveyType = intent.getStringExtra("surveyType") ?: ""
        when (surveyType) {
            "FoodPreferences" -> {
                binding.tvSurveyTitle.text = "Food Preferences"
                generateSurvey(foodPreferencesQuestions)
                numOfQuestions = foodPreferencesQuestions.size
            }

            "DietaryHabits" -> {
                binding.tvSurveyTitle.text = "Dietary Habits"
                generateSurvey(dietaryHabitsQuestions)
                numOfQuestions = dietaryHabitsQuestions.size
            }
        }

        binding.btnSubmit.setOnClickListener {
            displaySurveyResults()

        }
    }
    private fun displaySurveyResults() {
        val resultsBuilder = StringBuilder()
        if (surveyResponses.size < numOfQuestions) {
            Toast.makeText(this, "Please answer all questions", Toast.LENGTH_LONG).show()
            return
        }
        for ((question, answer) in surveyResponses) {
            resultsBuilder.append("$question: $answer\n\n")
        }
        binding.tvSurveyResults.text = resultsBuilder.toString()
        binding.tvSurveyResults.visibility = View.VISIBLE
    }
    private fun generateSurvey(questionsMap: Map<String, List<String>>) {
        questionsMap.forEach { (question, answers) ->
            // Create a TextView for the question
            val questionText = createTextView(question)
            binding.linearLayoutQuestions.addView(questionText) // Add to the questions LinearLayout

            // Create a RadioGroup for the answers
            val radioGroup = RadioGroup(this).apply {
                orientation = RadioGroup.VERTICAL
                setPadding(resources.getDimension(R.dimen.padding_standard).toInt())
            }

            answers.forEach { answer ->
                val radioButton = createRadioButton(answer)
                radioGroup.addView(radioButton)
            }

            // Set listener for the RadioGroup to store the selected answer
            radioGroup.setOnCheckedChangeListener { group, checkedId ->
                val selectedAnswer = group.findViewById<RadioButton>(checkedId).text.toString()
                surveyResponses[question] = selectedAnswer
            }

            binding.linearLayoutQuestions.addView(radioGroup) // Add to the questions LinearLayout
        }
    }



    private fun createTextView(question: String) = TextView(this).apply {
        text = question
        textSize = 18f
        setTypeface(typeface, Typeface.BOLD)
        layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            setMargins(0, 0, 0, resources.getDimension(R.dimen.margin_standard).toInt())
        }
    }

    private fun createRadioButton(answer: String) = RadioButton(this).apply {
        text = answer
        layoutParams = RadioGroup.LayoutParams(
            RadioGroup.LayoutParams.MATCH_PARENT,
            RadioGroup.LayoutParams.WRAP_CONTENT
        )
    }
}
