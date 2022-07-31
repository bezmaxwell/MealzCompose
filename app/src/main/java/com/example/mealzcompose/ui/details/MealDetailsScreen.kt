package com.example.mealzcompose.ui.details

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import coil.compose.AsyncImage
import com.example.mealzcompose.model.response.MealResponse
import java.lang.Float.min


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

    val scrollState = rememberLazyListState()
    val offset = min(1f, 1 -
            (scrollState.firstVisibleItemScrollOffset / 600f
                    * scrollState.firstVisibleItemIndex))
    val size by animateDpAsState(targetValue = max(100.dp, 148.dp * offset))

    Surface(color = MaterialTheme.colors.background) {

        Column {
            Surface(elevation = 4.dp) {
                Row(modifier = Modifier.fillMaxWidth()) {
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
                                .size(size)
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
            val dummyContentList = (0..100).map { it.toString() }
            LazyColumn(state = scrollState) {
                items(dummyContentList) { dummyItem ->
                    Text(text = dummyItem, modifier = Modifier.padding(24.dp))

                }
            }
        }
    }
}

enum class MealProfilePictureState(val color: Color, val size: Dp, val borderWidth: Dp) {
    Normal(Color.Magenta, 120.dp, 8.dp),
    Expanded(Color.Green, 200.dp, 24.dp)
}