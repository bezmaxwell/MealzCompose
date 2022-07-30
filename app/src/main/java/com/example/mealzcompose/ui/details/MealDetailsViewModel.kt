package com.example.mealzcompose.ui.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.mealzcompose.model.MealsRepository
import com.example.mealzcompose.model.response.MealResponse

class MealDetailsViewModel(
    saveStateHandle: SavedStateHandle
) : ViewModel() {

    private val repository: MealsRepository = MealsRepository.getInstance()

    val mealState = mutableStateOf<MealResponse?>(null)

    init {
        val mealId = saveStateHandle.get<String>("meal_category_id") ?: ""
        mealState.value = repository.getMeal(mealId)
    }
}