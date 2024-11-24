package com.example.kt_homework2_2024.repo

import com.example.kt_homework2_2024.model.DogWrapper

/**
 * Нет надобности в этом интерфейсе.
 *
 * Стандартная рекомендация для использования абстракций в коде - использовать их
 * только тогда, когда предполагается наличие нескольких имплементаций
 *
 * Например если бы у тебя было 2 api - RemoteDogApi(сетевые запросы) и CacheDogApi(кэшированные данные),
 * то наличие единого контракта(интерфейса) для них было бы оправданным решением.
 */
interface RandomDogApiRepo {

	suspend fun getRandomDog(): DogWrapper
}