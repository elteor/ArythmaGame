package com.elteor.arythmagame.data

import com.elteor.arythmagame.logic.Question

object QuestionHolder {
    private var questionList : MutableList<Question> = mutableListOf()
    private var answerList : MutableList<String> = mutableListOf()
    private var booleanList : MutableList<Boolean> = mutableListOf()
// Question Methods
    fun addQuestion(question: Question){
        questionList.add(question)
    }

    fun setQuestions(questionList : MutableList<Question>){
        this.questionList = questionList
    }

    fun getQuestionList() : MutableList<Question>{
        return questionList
    }
// Answer Methods
    fun addAnswer(string : String){
        answerList.add(string)
    }
    fun addAnswer(string : String, position : Int){
        answerList[position] = string
    }

    fun setAnswers(answerList : MutableList<String>){
        this.answerList = answerList
    }
    fun getAnswersList() : MutableList<String>{
        return answerList
    }

//  Boolean Methods

    fun addBool(boolean : Boolean){
        booleanList.add(boolean)
    }
    fun addBool(boolean : Boolean, position : Int){
        booleanList[position] = boolean
    }

    fun setBools(booleanList : MutableList<Boolean>){
        this.booleanList = booleanList
    }

    fun getBools() : MutableList<Boolean>{
        return booleanList
    }
}