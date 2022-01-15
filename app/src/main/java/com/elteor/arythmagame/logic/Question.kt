package com.elteor.arythmagame.logic
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.roundToInt

abstract class Question {

    protected val operators : Array<String> = arrayOf("+", "-", "*", "/")
    protected var numberList : MutableList<Int> = mutableListOf()
    protected var operatorList : MutableList<String> = mutableListOf()
    var question = ""
    var answer = ""

    abstract fun generateQuestion()

    fun evaluateAnswer(){
        for (i in (0 until numberList.count())){
            question += "${numberList[i]} "
            if (i < operatorList.count()-1){
                question += "${operatorList[i]} "
            }
        }
        val expression : Expression = ExpressionBuilder(question).build()
        if (question.contains("/")){
            answer = ((expression.evaluate() * 10.0).roundToInt() / 10.0).toString()
            if (answer.endsWith(".0")){
                answer = answer.dropLast(2)
            }
        } else{
            answer = expression.evaluate().toInt().toString()
        }
    }
}