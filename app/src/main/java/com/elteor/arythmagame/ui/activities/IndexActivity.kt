package com.elteor.arythmagame.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elteor.arythmagame.data.QuestionHolder
import com.elteor.arythmagame.data.SharedPrefs
import com.elteor.arythmagame.databinding.ActivityIndexBinding
import com.elteor.arythmagame.logic.questions.factory.EasyQuestionFactory
import com.elteor.arythmagame.logic.questions.factory.HardQuestionFactory
import com.elteor.arythmagame.logic.questions.factory.MediumQuestionFactory
import com.elteor.arythmagame.logic.questions.factory.QuestionFactory
import com.elteor.arythmagame.ui.adapters.FragmentAdapter

class IndexActivity : AppCompatActivity() {
    private lateinit var binding : ActivityIndexBinding
    private lateinit var prefs : SharedPrefs

    private val questionHolder = QuestionHolder
    private val easyQuestionFactory : QuestionFactory = EasyQuestionFactory()
    private val mediumQuestionFactory : QuestionFactory = MediumQuestionFactory()
    private val hardQuestionFactory : QuestionFactory = HardQuestionFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityIndexBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        prefs = SharedPrefs(this)

        when(prefs.getMode()){
            "medium" -> questionCreator(mediumQuestionFactory, 9)
            "hard" -> questionCreator(hardQuestionFactory, 19)
            else -> questionCreator(easyQuestionFactory, 4)
        }

        val viewPager2 = binding.viewPager
        val adapter = FragmentAdapter(supportFragmentManager,lifecycle)
        viewPager2.adapter = adapter
    }

    private fun questionCreator(questionFactoryType : QuestionFactory, iterations : Int){
        for (i in (0..iterations)) {
            val question = questionFactoryType.createQuestion()
            question.generateQuestion()
            questionHolder.addQuestion(question)
            questionHolder.addAnswer("")
            questionHolder.addBool(false)
        }
    }
}