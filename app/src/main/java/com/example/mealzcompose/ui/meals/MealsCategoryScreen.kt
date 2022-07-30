package com.example.mealzcompose.ui.meals

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mealzcompose.ui.theme.MealzComposeTheme

class MealsCategoryScreen {


    @Composable
    fun MealsCategoryScreen() {
        /** @see LaunchedEffect(keys = , block = )  * use to not run every time composable is called */
        //  val coroutineScope = rememberCoroutineScope()  ==>  LaunchedEffect(key1 = "GET_MEALS") { }

        val viewModel: MealsCategoriesViewModel = viewModel()
        val meals = viewModel.mealState.value

        LazyColumn {
            items(meals) { meal ->
                Text(text = meal.name)
            }
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MealzComposeTheme {
            MealsCategoryScreen()
        }
    }
}