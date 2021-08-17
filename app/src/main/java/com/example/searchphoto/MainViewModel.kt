package com.example.searchphoto

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.model.DataState
import com.example.core.model.consultation.SearchPhotos
import com.example.core.repository.consultation.usecases.GetPhotosByQueryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getPhotosByQuery: GetPhotosByQueryUseCase) :
        ViewModel() {

    private val _photosState: MutableLiveData<DataState<SearchPhotos>> = MutableLiveData()
    val picturesState: LiveData<DataState<SearchPhotos>>
        get() = _photosState


    fun setStateEvent(query: String, photosStateEvent: PhotosStateEvent) {
        viewModelScope.launch {
            when (photosStateEvent) {
                is PhotosStateEvent.GetPhotosEvents -> {
                    getPhotosByQuery.invoke(query)
                            .onEach { pictureState ->
                                _photosState.value = pictureState
                            }
                            .launchIn(viewModelScope)
                }

                is PhotosStateEvent.None -> {
                    //No Action
                }
            }
        }
    }
}

sealed class PhotosStateEvent {
    object GetPhotosEvents : PhotosStateEvent()
    object None : PhotosStateEvent()
}