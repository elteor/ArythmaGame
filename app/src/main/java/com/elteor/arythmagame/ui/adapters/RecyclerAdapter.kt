package com.elteor.arythmagame.ui.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.elteor.arythmagame.data.QuestionHolder
import com.elteor.arythmagame.databinding.RecyclerItemBinding

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    private val questionHolder = QuestionHolder

    inner class MyViewHolder(internal val binding: RecyclerItemBinding) : RecyclerView.ViewHolder(binding.root){
        internal lateinit var questionStr : String
        init {
            itemView.setOnClickListener {
                Toast.makeText(binding.root.context, questionStr, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.questionStr = questionHolder.getQuestionList()[position].question
        holder.binding.expected.text = "Expected: " + questionHolder.getQuestionList()[position].answer
        holder.binding.got.text = when(questionHolder.getAnswersList()[position]){
            "" -> "Got: Nothing"
            else -> "Got: " + questionHolder.getAnswersList()[position]
        }
        when(questionHolder.getBools()[position]) {
            true -> {
                holder.binding.answer.setTextColor(Color.parseColor("#00FF00"))
                holder.binding.answer.text = "Correct"
            }
            false -> {
                holder.binding.answer.setTextColor(Color.parseColor("#FF0000"))
                holder.binding.answer.text = "Wrong"
            }
        }
    }

    override fun getItemCount(): Int {
        return questionHolder.getQuestionList().size
    }
}