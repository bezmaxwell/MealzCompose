package com.example.mealzcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mealzcompose.ui.details.MealDetailsScreen
import com.example.mealzcompose.ui.details.MealDetailsViewModel
import com.example.mealzcompose.ui.meals.MealsCategoriesScreen
import com.example.mealzcompose.ui.theme.MealzComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzComposeTheme {
                FoodiezApp()
            }
        }
    }
}

@Composable
private fun FoodiezApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "destination_meals_list") {

        composable(route = "destination_meals_list") {
            MealsCategoriesScreen { navigationMealId ->
                navController.navigate("destination_meal_details/$navigationMealId")
            }
        }

        composable(
            route = "destination_meal_details/{meal_category_id}",
            arguments = listOf(navArgument("meal_category_id") {
                type = NavType.StringType
            })
        ) {
            val viewModel:MealDetailsViewModel = viewModel()
            MealDetailsScreen(viewModel.mealState.value)
        }
    }
}
