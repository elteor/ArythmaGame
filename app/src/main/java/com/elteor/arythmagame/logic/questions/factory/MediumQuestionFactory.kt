package com.elteor.arythmagame.logic.questions.factory

import com.elteor.arythmagame.logic.questions.MediumQuestion

class MediumQuestionFactory : QuestionFactory {
    override fun createQuestion(): MediumQuestion {
        return MediumQuestion()
    }
}