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
			model = ImageRequest.Builder(LocalContext.current)
				.data(url)
				.build(),
			contentDescription = "Some dog...",
			contentScale = ContentScale.Crop,
		)
	}
}