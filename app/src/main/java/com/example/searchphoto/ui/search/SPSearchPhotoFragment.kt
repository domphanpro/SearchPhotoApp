package com.example.searchphoto.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.core.model.DataState
import com.example.core.model.consultation.Result
import com.example.core.model.consultation.SearchPhotos
import com.example.searchphoto.R
import com.example.searchphoto.databinding.FragmentSpSearchPhotoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SPSearchPhotoFragment : Fragment(), SPPhotosAdapter.PhotoListener {

    private lateinit var fragmentBinding: FragmentSpSearchPhotoBinding

    private val viewModel: SPSearchPhotoViewModel by activityViewModels()

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
        val adapter = SPPhotosAdapter(this)
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

    override fun onItemClicked(photo: Result) {
        Toast.makeText(
                requireContext(),
                getString(R.string.add_favorite_message_success),
                Toast.LENGTH_LONG
        ).show()
        viewModel.insertPhoto(photo)
    }

}