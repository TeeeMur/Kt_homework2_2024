package com.example.kt_homework2_2024.repo

import com.example.kt_homework2_2024.model.DogData
import retrofit2.http.GET
import retrofit2.http.Query

interface DogApi {

	@GET(".")
	suspend fun getRandomDog(@Query("include") formats: String): DogData
}