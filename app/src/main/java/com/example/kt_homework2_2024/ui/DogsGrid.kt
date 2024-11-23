package com.example.kt_homework2_2024.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.kt_homework2_2024.Constants
import com.example.kt_homework2_2024.DogViewModel

@Composable
fun DogsGrid(
	viewModel: DogViewModel,
	gridState: LazyGridState
) {
	val screenConfig = LocalConfiguration.current
	val countOfColumns =
		(if (screenConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) Constants.INT_COUNT_OF_COLUMNS_LANDSCAPE
		else Constants.INT_COUNT_OF_COLUMNS_PORTRAIT)
	LazyVerticalGrid(
		modifier = Modifier.fillMaxSize(),
		verticalArrangement = Arrangement.spacedBy(10.dp),
		horizontalArrangement = Arrangement.spacedBy(10.dp),
		columns = GridCells.Fixed(countOfColumns),
		state = gridState,
		) {
		items(viewModel.urls) { url ->
			DogPicture(url,
				Modifier.size(300.dp))
		}
	}
}