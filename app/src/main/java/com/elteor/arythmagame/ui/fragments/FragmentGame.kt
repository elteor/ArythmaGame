package com.elteor.arythmagame.ui.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.elteor.arythmagame.data.QuestionHolder
import com.elteor.arythmagame.databinding.FragmentGameBinding
import com.elteor.arythmagame.logic.Question
import com.elteor.arythmagame.ui.activities.ResultsActivity

class FragmentGame(private val question: Question) : Fragment() {
    private lateinit var binding : FragmentGameBinding
    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentGameBinding.inflate(layoutInflater, container, false)
        val pos = QuestionHolder.getQuestionList().indexOf(question)
        binding.place.text = "${pos+1}/${QuestionHolder.getQuestionList().size}"
        binding.question.text = question.question
        binding.answer.setText(QuestionHolder.getAnswersList()[pos])

        binding.button.setOnClickListener {
            QuestionHolder.addAnswer(binding.answer.text.toString(), pos)
            QuestionHolder.addBool(binding.answer.text.toString() == question.answer, pos)
        }

        binding.button2.setOnClickListener {
            binding.root.context.startActivity(Intent(binding.root.context, ResultsActivity::class.java))
        }


        return binding.root
    }
}