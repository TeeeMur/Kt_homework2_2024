package com.example.kt_homework2_2024

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.lifecycle.ViewModelProvider

import com.example.kt_homework2_2024.ui.DogsGrid
import com.example.kt_homework2_2024.ui.theme.Kt_homework2_2024Theme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			val viewModel = ViewModelProvider(this)[DogViewModel::class]
			val gridState = rememberLazyGridState()
			Kt_homework2_2024Theme {
				DogsGrid(viewModel, gridState)
			}
		}
	}
}

