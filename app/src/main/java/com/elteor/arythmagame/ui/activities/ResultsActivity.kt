package com.elteor.arythmagame.ui.activities;

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.elteor.arythmagame.data.QuestionHolder
import com.elteor.arythmagame.databinding.ActivityResultsBinding
import com.elteor.arythmagame.ui.adapters.RecyclerAdapter

class ResultsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityResultsBinding
    private val questionHolder = QuestionHolder

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityResultsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RecyclerAdapter()
        val predicate: (Boolean) -> Boolean = { it }
        val correctCount : Int = questionHolder.getBools().count(predicate)
        binding.result.text = "${correctCount}/${questionHolder.getQuestionList().size}"
        when {
            correctCount.toFloat()/questionHolder.getQuestionList().size.toFloat() <= 0.33f -> {
                binding.result.setTextColor(Color.parseColor("#FF0000"))
            }
            correctCount.toFloat()/questionHolder.getQuestionList().size.toFloat() >= 0.66f -> {
                binding.result.setTextColor(Color.parseColor("#00FF00"))
            }
            else -> binding.result.setTextColor(Color.parseColor("#FFA500"))
        }
    }
}