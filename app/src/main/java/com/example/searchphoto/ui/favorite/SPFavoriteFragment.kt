package com.example.searchphoto.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.core.model.DataState
import com.example.core.model.consultation.Result
import com.example.searchphoto.R
import com.example.searchphoto.databinding.FragmentSpFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SPFavoriteFragment : Fragment() {

    private lateinit var fragmentBinding: FragmentSpFavoriteBinding

    private val viewModel: SPFavoriteViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        fragmentBinding = FragmentSpFavoriteBinding.inflate(inflater, container, false)
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getFavoritePhotos()
    }

    private fun subscribeObservers() {
        val adapter = SPFavoriteAdapter()
        fragmentBinding.favoriteRecyclerView.apply {
            this.adapter = adapter
        }

        viewModel.photosState.observe(viewLifecycleOwner, { pictureState ->
            when (pictureState) {
                is DataState.Success<List<Result>> -> {
                    adapter.submitList(pictureState.data)
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


}