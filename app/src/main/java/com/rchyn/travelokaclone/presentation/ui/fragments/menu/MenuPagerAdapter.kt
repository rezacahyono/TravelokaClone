package com.rchyn.travelokaclone.presentation.ui.fragments.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MenuPagerAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        val fragment = MenuFragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG_MENU_SECTION, position + 1)
        }
        return fragment
    }
}