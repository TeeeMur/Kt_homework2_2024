package com.example.kt_homework2_2024.repo

import com.example.kt_homework2_2024.model.DogData

val LIST_STRING_FORMATS: List<String> = listOf("jpg", "gif", "png")

class RandomDogApiRepoImpl(
	private val api: DogApi
){
	suspend fun getRandomDog(): DogData = api.getRandomDog(LIST_STRING_FORMATS.joinToString(separator = ","))
}