package com.example.kt_homework2_2024.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.kt_homework2_2024.R

@Composable
fun DogPicture(
	url: String,
	modifier: Modifier,
) {
	Box(
		modifier = modifier,
		contentAlignment = Alignment.Center
		) {
		AsyncImage(
			/**
			 * Кажется ты не добавил догрузку данных в случае ошибки.
			 *
			 * Как обычно работают подобные приложения:
			 * 1. Чтобы загрузить 10 картинок ты делаешь 1 запрос, в котором
			 * тебе возвращается json с 10 картинками.
			 * 2. Далее AsyncImage делает еще 10 запросов на загрузку картинки (ты можешь
			 * увидеть это поведение в AppInspection -> Network
			 *
			 * В таком случае у тебя есть вероятность, что первый запрос на получение json у тебя
			 * прошел. Потом отлетел интернет и картинки не загрузились. Нужно добавить обработку
			 * этого случая
			 */
			model = ImageRequest.Builder(LocalContext.current)
				.data(url)
				.build(),
			/**
			 * В ДЗ по котлину запрещен хардкод.
			 */
			contentDescription = "Some dog...",
			contentScale = ContentScale.Crop,
		)
	}
}