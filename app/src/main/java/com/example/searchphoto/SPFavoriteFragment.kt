package com.example.searchphoto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.searchphoto.databinding.FragmentSpFavoriteBinding

class SPFavoriteFragment : Fragment() {

    private lateinit var fragmentBinding: FragmentSpFavoriteBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        fragmentBinding = FragmentSpFavoriteBinding.inflate(inflater, container, false)
        return fragmentBinding.root
    }

}