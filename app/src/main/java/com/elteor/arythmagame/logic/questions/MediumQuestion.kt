package com.elteor.arythmagame.logic.questions

import com.elteor.arythmagame.logic.Question

class MediumQuestion : Question() {

    override fun generateQuestion() {
        for (i in (0..3)){
            numberList.add((0..51).random())
            operatorList.add(operators[(0..2).random()])
        }
        evaluateAnswer()
    }
}