package com.elteor.arythmagame.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.elteor.arythmagame.data.QuestionHolder
import com.elteor.arythmagame.ui.fragments.FragmentGame

class FragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = QuestionHolder.getQuestionList().size

    override fun createFragment(position: Int): Fragment {
        return FragmentGame(QuestionHolder.getQuestionList()[position])
    }
}