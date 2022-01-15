package com.elteor.arythmagame.logic.questions.factory

import com.elteor.arythmagame.logic.questions.EasyQuestion

class EasyQuestionFactory : QuestionFactory {
    override fun createQuestion() : EasyQuestion {
        return EasyQuestion()
    }
}