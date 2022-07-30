package com.example.mealzcompose.model

import com.example.mealzcompose.model.api.MealsWebService
import com.example.mealzcompose.model.response.MealsCategoriesResponse

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {

     suspend fun getMeals():MealsCategoriesResponse {
        return webService.getMeals()
    }

}