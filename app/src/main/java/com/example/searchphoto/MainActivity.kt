package com.example.searchphoto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.searchphoto.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.spContainerView.addView(
            SPTabLayout(context = this).also {
                it.setup(SPPagerAdapter(supportFragmentManager))
            }
        )
    }
}