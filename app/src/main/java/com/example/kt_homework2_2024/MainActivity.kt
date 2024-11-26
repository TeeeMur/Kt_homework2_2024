package com.example.kt_homework2_2024

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider

import com.example.kt_homework2_2024.ui.DogsGrid
import com.example.kt_homework2_2024.ui.theme.Kt_homework2_2024Theme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			val viewModel = ViewModelProvider(this)[DogViewModel::class]
			val gridState = rememberLazyStaggeredGridState()
			Kt_homework2_2024Theme {
				Column(
					modifier = Modifier
						.fillMaxSize()
						.background(colorResource(R.color.black))
						.padding(10.dp),
					verticalArrangement = Arrangement.SpaceBetween,
				) {
					DogsGrid(viewModel, gridState)
					Button(
						onClick = {viewModel.getTenDogPictureUrls()},
						modifier = Modifier.fillMaxWidth(),
						colors = ButtonDefaults.buttonColors(containerColor = Color.White)
					) {
						Text(stringResource(R.string.button_text),
							color = colorResource(R.color.black),
							fontSize = 24.sp)
					}
				}
			}
		}
	}
}

