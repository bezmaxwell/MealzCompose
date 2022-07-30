package com.example.mealzcompose.model

import com.example.mealzcompose.model.api.MealsWebService
import com.example.mealzcompose.model.response.MealResponse
import com.example.mealzcompose.model.response.MealsCategoriesResponse

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {

    private var cachedMeals = listOf<MealResponse>()

     suspend fun getMeals():MealsCategoriesResponse {
         val response = webService.getMeals()
         cachedMeals = response.categories
        return response
    }

    fun getMeal(id:String): MealResponse? {
        return cachedMeals.firstOrNull {
            it.id == id
        }
    }

    companion object {
        @Volatile
        private var instance:MealsRepository? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: MealsRepository().also { instance = it }
        }
    }
}