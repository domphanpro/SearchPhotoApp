package com.example.searchphoto.ui.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.searchphoto.databinding.ActivityMainBinding
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext

@Module
@InstallIn(ActivityComponent::class)
object MainActivityModule {

    @Provides
    fun binding(@ActivityContext context: Context): ActivityMainBinding {
        return ActivityMainBinding.inflate((context as AppCompatActivity).layoutInflater)
    }
}