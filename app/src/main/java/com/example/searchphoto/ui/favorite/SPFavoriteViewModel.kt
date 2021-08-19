package com.example.searchphoto.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.model.DataState
import com.example.core.model.consultation.Result
import com.example.core.repository.consultation.usecases.FavoritePhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SPFavoriteViewModel @Inject constructor(private val favoritePhotosUseCase: FavoritePhotosUseCase) :
        ViewModel() {

    private val _photosState: MutableLiveData<DataState<List<Result>>> = MutableLiveData()
    val photosState: LiveData<DataState<List<Result>>>
        get() = _photosState

    fun getFavoritePhotos() {
        viewModelScope.launch {
            favoritePhotosUseCase.getPhotosFavorite()
                    .onEach { pictureState ->
                        _photosState.value = pictureState
                    }
                    .launchIn(viewModelScope)
        }
    }
}