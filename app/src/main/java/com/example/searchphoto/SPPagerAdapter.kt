package com.example.searchphoto

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class SPPagerAdapter(
        fragmentManager: FragmentManager
) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val searchFragment by lazy {
        SPSearchPhotoFragment()
    }

    private val favoriteFragment by lazy {
        SPFavoriteFragment()
    }

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        return if(position == 0) {
            searchFragment
        } else {
            favoriteFragment
        }
    }
}