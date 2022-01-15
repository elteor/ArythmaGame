package com.elteor.arythmagame.logic.questions.factory

import com.elteor.arythmagame.logic.Question

interface QuestionFactory {
    fun createQuestion() : Question
}