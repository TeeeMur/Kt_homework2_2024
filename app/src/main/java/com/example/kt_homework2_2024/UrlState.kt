package com.example.kt_homework2_2024

import com.example.kt_homework2_2024.model.DogData

sealed interface UrlState {
	data class Success(val photo: DogData) : UrlState
	data object Error : UrlState
	data object Loading : UrlState
}