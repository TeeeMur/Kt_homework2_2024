package com.example.kt_homework2_2024.ui

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.kt_homework2_2024.DogViewModel
import com.example.kt_homework2_2024.R

const val INT_COUNT_OF_COLUMNS_LANDSCAPE = 3
const val INT_COUNT_OF_COLUMNS_PORTRAIT = 2
const val FLOAT_SIZE_OF_GRID_LANDSCAPE = 0.8f
const val FLOAT_SIZE_OF_GRID_PORTRAIT = 0.92f
val INT_WIDTH_OF_PICTURE = 200.dp

@Composable
fun DogsGrid(
	viewModel: DogViewModel,
	gridState: LazyStaggeredGridState
) {
	val screenConfig = LocalConfiguration.current
	val globalState by viewModel.globalStateFlow.collectAsState()
	val countOfColumns =
		remember {
			(if (screenConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) INT_COUNT_OF_COLUMNS_LANDSCAPE
			else INT_COUNT_OF_COLUMNS_PORTRAIT)
		}
	val gridMaxHeight =
		remember {if (screenConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
		FLOAT_SIZE_OF_GRID_LANDSCAPE else FLOAT_SIZE_OF_GRID_PORTRAIT}
	LazyVerticalStaggeredGrid(
		modifier = Modifier.fillMaxHeight(gridMaxHeight),
		horizontalArrangement = Arrangement.spacedBy(5.dp),
		verticalItemSpacing = 10.dp,
		columns = StaggeredGridCells.Fixed(countOfColumns),
		state = gridState,
	) {
		itemsIndexed(globalState.urlsList) {index, item ->
			DogPicture(
				index,
				Modifier
					.width(INT_WIDTH_OF_PICTURE)
					.clip(RoundedCornerShape(8.dp))
					.border(
						2.dp,
						colorResource(R.color.white),
						RoundedCornerShape(8.dp)
					),
				item,
				viewModel,
			)
		}
	}
}