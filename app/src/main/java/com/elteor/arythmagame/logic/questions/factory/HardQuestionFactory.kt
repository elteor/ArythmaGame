package com.elteor.arythmagame.logic.questions.factory

import com.elteor.arythmagame.logic.questions.HardQuestion

class HardQuestionFactory : QuestionFactory {
    override fun createQuestion() : HardQuestion{
        return HardQuestion()
    }
}