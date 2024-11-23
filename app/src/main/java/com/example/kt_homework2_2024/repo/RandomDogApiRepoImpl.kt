package com.example.kt_homework2_2024.repo

import com.example.kt_homework2_2024.model.DogWrapper

class RandomDogApiRepoImpl(
	private val api: DogApi
): RandomDogApiRepo {
	override suspend fun getRandomDog(): DogWrapper {
		return api.getRandomDog()
	}

}