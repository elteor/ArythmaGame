package com.elteor.arythmagame.logic.questions

import com.elteor.arythmagame.logic.Question

class HardQuestion : Question() {

    override fun generateQuestion() {
        for (i in (0..5)){
            numberList.add((1..100).random())
            operatorList.add(operators[(0..3).random()])
        }
        evaluateAnswer()
    }
}