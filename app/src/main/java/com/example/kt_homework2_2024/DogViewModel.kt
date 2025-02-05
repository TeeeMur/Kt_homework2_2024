package com.example.kt_homework2_2024

import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.Coil
import com.example.kt_homework2_2024.di.AppModule
import com.example.kt_homework2_2024.repo.RandomDogApiRepo
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DogViewModel(): ViewModel() {

	private val repo = AppModule.provideRandomDogApiRepo(AppModule.provideRandomDogApi())

	private val _urls = mutableStateListOf<String>()
	val urls = _urls

	fun getDogPictureUrl() {
		viewModelScope.launch {
			_urls.add(repo.getRandomDog().url)
		}
	}

}