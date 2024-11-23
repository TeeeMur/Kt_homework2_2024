package com.example.kt_homework2_2024.repo

import com.example.kt_homework2_2024.model.DogWrapper

interface RandomDogApiRepo {

	suspend fun getRandomDog(): DogWrapper
}