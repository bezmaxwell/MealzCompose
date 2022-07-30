package com.example.mealzcompose.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealzcompose.model.MealsRepository
import com.example.mealzcompose.model.response.MealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository.getInstance()) :
    ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val meals = getMeals()
            mealState.value = meals
        }
    }

    val mealState: MutableState<List<MealResponse>> = mutableStateOf(emptyList<MealResponse>())

    private suspend fun getMeals(): List<MealResponse> {
        return repository.getMeals().categories
    }

}