package com.example.kt_homework2_2024.model

/**
 * Название на мой взгляд неудачное. Не совсем понятно, почему это "обертка"
 * Обычно такие классы являются частью data-слоя. Мы на проекте называем подобные классы DogData
 */

/**
 * Лучше также не хранить ненужные данные.
 * fileSizeBytes - не используется
 */
data class DogWrapper (
	val fileSizeBytes: Int,
	val url: String,
)

