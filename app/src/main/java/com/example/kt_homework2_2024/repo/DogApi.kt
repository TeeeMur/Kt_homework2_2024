package com.example.kt_homework2_2024.repo

import com.example.kt_homework2_2024.model.DogWrapper
import retrofit2.http.GET

interface DogApi {

	@GET(".")
	suspend fun getRandomDog(): DogWrapper
}