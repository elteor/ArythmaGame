package com.elteor.arythmagame.ui.activities;

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elteor.arythmagame.data.QuestionHolder
import com.elteor.arythmagame.data.SharedPrefs
import com.elteor.arythmagame.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var prefs : SharedPrefs
    private val questionHolder = QuestionHolder
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        prefs = SharedPrefs(this)

        when(prefs.getMode()){
            "medium" -> binding.radioMedium.isChecked = true
            "hard" -> binding.radioHard.isChecked = true
            "easy" -> binding.radioEasy.isChecked = true
        }

        binding.radioGroup.setOnCheckedChangeListener { _, i ->
            when(i){
                binding.radioEasy.id -> {
                    prefs.setMode("easy")
                }
                binding.radioMedium.id -> {
                    prefs.setMode("medium")
                }
                binding.radioHard.id -> {
                    prefs.setMode("hard")
                }
            }
            Snackbar.make(binding.container, "Game mode set to ${prefs.getMode()}", Snackbar.LENGTH_SHORT).show()
        }

        binding.buttonStart.setOnClickListener { startActivity(Intent(this, IndexActivity::class.java)) }
    }
    override fun onResume() {
        super.onResume()
        questionHolder.setQuestions(mutableListOf())
        questionHolder.setAnswers(mutableListOf())
        questionHolder.setBools(mutableListOf())
    }
}