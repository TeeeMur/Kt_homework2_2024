package com.example.kt_homework2_2024

/**
 * Плохая идея выносить константы в глобальную область видимости тк с ростом приложения этот файл будет
 * становиться нечитабельным
 *
 * Чаще всего константы прихранивают рядом с местом использования
 */
object Constants {

	const val BASE_URL: String = "https://random.dog/woof.json/"
	const val INT_COUNT_OF_COLUMNS_LANDSCAPE = 3
	const val INT_COUNT_OF_COLUMNS_PORTRAIT = 2

}