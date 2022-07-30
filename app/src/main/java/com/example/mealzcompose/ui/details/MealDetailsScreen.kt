package com.example.mealzcompose.ui.details

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.mealzcompose.model.response.MealResponse


//var profilePictureState by remember { mutableStateOf(MealProfilePictureState.Normal) }
//val transitionState = updateTransition(targetState = profilePictureState, label = "")
//val imageSizeDp by transitionState.animateDp(targetValueByState = { it.size }, label = "")
//val color by transitionState.animateColor(targetValueByState = { it.color }, label = "")
//val widthSize by transitionState.animateDp(targetValueByState = { it.borderWidth }, label = "")

//Button(
//modifier = Modifier
//.padding(16.dp),
//onClick = {
//    profilePictureState = if (profilePictureState == MealProfilePictureState.Normal)
//        MealProfilePictureState.Expanded
//    else
//        MealProfilePictureState.Normal
//}) {
//    Text(text = "Change state of meal profile picture")
//
//}

@Composable
fun MealDetailsScreen(meal: MealResponse?) {


    Surface(color = MaterialTheme.colors.background) {

        Column {
            Row {
                Card(
                    modifier = Modifier.padding(16.dp),
                    shape = CircleShape,
                    border = BorderStroke(
                        width = 2.dp,
                        color = Color.Green
                    )
                ) {
                    AsyncImage(
                        model = meal?.imageUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(200.dp)
                            .padding(8.dp)
                    )
                }
                Text(
                    text = meal?.name ?: "default name",
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterVertically)
                )
            }

        }
    }
}

enum class MealProfilePictureState(val color: Color, val size: Dp, val borderWidth: Dp) {
    Normal(Color.Magenta, 120.dp, 8.dp),
    Expanded(Color.Green, 200.dp, 24.dp)
}