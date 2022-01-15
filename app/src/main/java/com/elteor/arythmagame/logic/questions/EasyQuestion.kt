package com.elteor.arythmagame.logic.questions

import com.elteor.arythmagame.logic.Question

class EasyQuestion : Question() {

    override fun generateQuestion() {
        for (i in (0..1)){
            numberList.add((1..21).random())
            operatorList.add(operators[(0..1).random()])
        }
        evaluateAnswer()
    }
}