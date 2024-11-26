package com.example.kt_homework2_2024

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kt_homework2_2024.di.AppModule
import com.example.kt_homework2_2024.model.GlobalScreenState
import com.example.kt_homework2_2024.model.ScreenContent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import kotlin.collections.List

class DogViewModel : ViewModel() {

	private val repo = AppModule.provideRandomDogApiRepo(AppModule.provideRandomDogApi())

	private val _globalStateFlow: MutableStateFlow<ScreenContent> = MutableStateFlow(ScreenContent())
	val globalStateFlow = _globalStateFlow.asStateFlow()

	init {
		getTenDogPictureUrls()
	}

	fun getTenDogPictureUrls() {
		viewModelScope.launch {
			_globalStateFlow.update { oldValue ->
				oldValue.copy(urlsList = oldValue.urlsList + List(10) { UrlState.Loading })
			}
			val dogList = mutableListOf<UrlState>()
			repeat(10) {
				dogList.add(
					try {
						UrlState.Success(repo.getRandomDog())
					} catch (e: IOException) {
						UrlState.Error
					} catch (e: HttpException) {
						UrlState.Error
					}
				)
			}
			_globalStateFlow.update { oldValue ->
				val resultList = oldValue.urlsList.toMutableList()
				for (i in 0..9) {
					resultList[resultList.lastIndex - i] = dogList[9 - i]
				}
				oldValue.copy(urlsList = resultList.toList(), globalState = GlobalScreenState.Content)
			}
		}
	}

	fun reloadPictureUrl(index: Int) {
		viewModelScope.launch {
			_globalStateFlow.update { oldValue ->
				val tempList = oldValue.urlsList.toMutableList()
				oldValue.copy(urlsList = tempList.also { it[index] = UrlState.Loading }.toList())
			}
			val resultUrlState = (try {
				UrlState.Success(repo.getRandomDog())
			} catch (e: IOException) {
				UrlState.Error
			} catch (e: HttpException) {
				UrlState.Error
			})
			_globalStateFlow.update { oldValue ->
				val tempList = oldValue.urlsList.toMutableList()
				oldValue.copy(urlsList = tempList.also { it[index] = resultUrlState }.toList())
			}
		}
	}

}