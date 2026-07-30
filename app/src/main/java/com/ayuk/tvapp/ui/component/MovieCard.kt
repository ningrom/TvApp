package com.ayuk.tvapp.ui.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ayuk.tvapp.data.model.Tvshow

@Composable
fun MovieCard(
    show: Tvshow,
    modifier: Modifier = Modifier,
    onClick: (Tvshow) -> Unit = {}
) {
    Card(
        onClick = {
           onClick(show)
        },
        modifier = modifier
            .widthIn(max = 220.dp)
            .aspectRatio(2f / 3f)
    ) {

        AsyncImage(
            model = show.imageUrl?.length,
            contentDescription = show.name,
            contentScale = ContentScale.Crop
        )
    }
}