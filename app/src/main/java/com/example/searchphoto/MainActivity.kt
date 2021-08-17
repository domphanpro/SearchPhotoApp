package com.example.searchphoto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.core.model.DataState
import com.example.core.model.consultation.SearchPhotos
import com.example.searchphoto.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        subscribeObservers()
        viewModel.setStateEvent("voiture", PhotosStateEvent.GetPhotosEvents)
    }

    private fun subscribeObservers() {
        viewModel.picturesState.observe(this, { pictureState ->
            when (pictureState) {
                is DataState.Success<SearchPhotos> -> {
                    println(pictureState)
                }
                is DataState.Loading -> {

                }
                is DataState.Error -> {
                    displayToastError()
                }
            }
        })
    }

    private fun displayToastError() {
        Toast.makeText(this, getString(R.string.generic_message_error), Toast.LENGTH_LONG).show()
    }
}