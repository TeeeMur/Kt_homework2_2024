package com.example.kt_homework2_2024.di

import com.example.kt_homework2_2024.Constants
import com.example.kt_homework2_2024.repo.DogApi
import com.example.kt_homework2_2024.repo.RandomDogApiRepo
import com.example.kt_homework2_2024.repo.RandomDogApiRepoImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppModule {

	fun provideRandomDogApi(): DogApi {
		return Retrofit.Builder()
			.baseUrl(Constants.BASE_URL)
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create(DogApi::class.java)
	}

	fun provideRandomDogApiRepo(api: DogApi): RandomDogApiRepo {
		return RandomDogApiRepoImpl(api)
	}

}