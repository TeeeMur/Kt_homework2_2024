package com.example.kt_homework2_2024.model

import com.example.kt_homework2_2024.UrlState

sealed interface GlobalScreenState {
	data object Loading: GlobalScreenState
	data object Content: GlobalScreenState
}

data class ScreenContent(
	val urlsList: List<UrlState> = emptyList(),
	val globalState: GlobalScreenState = GlobalScreenState.Loading,
)
