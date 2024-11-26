package com.example.kt_homework2_2024.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImagePainter
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.SubcomposeAsyncImageContent
import coil3.request.ImageRequest
import com.example.kt_homework2_2024.DogViewModel
import com.example.kt_homework2_2024.R
import com.example.kt_homework2_2024.UrlState

@Composable
fun DogPicture(
	urlStateIndex: Int,
	modifier: Modifier,
	urlState: UrlState,
	viewModel: DogViewModel
) {
	Box(
		contentAlignment = Alignment.Center,
		modifier = modifier,
	) {
		when (urlState) {
			is UrlState.Error -> {
				Button(onClick = { viewModel.reloadPictureUrl(urlStateIndex) }) {
					Text(text = stringResource(R.string.button_text))
				}
			}
			is UrlState.Loading -> {
				CircularProgressIndicator(
					modifier = Modifier.padding(10.dp)
				)
			}
			is UrlState.Success -> {
				SubcomposeAsyncImage(
					model = ImageRequest.Builder(LocalContext.current)
						.data(urlState.photo.url)
						.size(coil3.size.Size.ORIGINAL)
						.build(),
					contentDescription = stringResource(R.string.dog_image_description),
					contentScale = ContentScale.FillWidth
				) {
					val state by painter.state.collectAsState()
					when (state) {
						is AsyncImagePainter.State.Success -> {
							SubcomposeAsyncImageContent(
								modifier = Modifier.fillMaxWidth()
							)
						}
						is AsyncImagePainter.State.Error -> {
							Button(onClick = {
								painter.restart()
							}) {
								Text(stringResource(R.string.button_text))
							}
						}
						is AsyncImagePainter.State.Loading -> {
							CircularProgressIndicator(
								modifier = Modifier.padding(10.dp)
							)
						}
						else -> {
							Text(stringResource(R.string.button_text))
						}
					}
				}
			}
		}
	}
}