package com.example.kt_homework2_2024.repo

import com.example.kt_homework2_2024.model.DogWrapper

class RandomDogApiRepoImpl(
	private val api: DogApi
): RandomDogApiRepo {

	/**
	 * В kotlin-style обычно такие вещи инлайнят(пишут в одну строку)
	 * getRandomDog() = api.getRandomDog()
	 */
	override suspend fun getRandomDog(): DogWrapper {
		return api.getRandomDog()
	}

}