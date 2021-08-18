package com.example.searchphoto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.core.model.DataState
import com.example.core.model.consultation.SearchPhotos
import com.example.searchphoto.databinding.FragmentSpSearchPhotoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SPSearchPhotoFragment : Fragment() {

    private lateinit var fragmentBinding: FragmentSpSearchPhotoBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentBinding = FragmentSpSearchPhotoBinding.inflate(inflater, container, false)
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentBinding.searchPhotoButton.setOnClickListener {
            launchSearch()
        }
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val adapter = SPPhotosAdapter()
        fragmentBinding.searchPhotoRecyclerView.apply {
            this.adapter = adapter
        }

        viewModel.picturesState.observe(viewLifecycleOwner, { pictureState ->
            when (pictureState) {
                is DataState.Success<SearchPhotos> -> {
                    adapter.submitList(pictureState.data.results)
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
        Toast.makeText(
            requireContext(),
            getString(R.string.generic_message_error),
            Toast.LENGTH_LONG
        ).show()
    }

    private fun launchSearch() {
        viewModel.setStateEvent(
            fragmentBinding.searchPhotoSearchView.query.toString(),
            PhotosStateEvent.GetPhotosEvents
        )
    }

}