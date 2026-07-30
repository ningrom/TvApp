package com.ayuk.tvapp.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Card
import coil.compose.AsyncImage
import com.ayuk.tvapp.data.model.Tvshow

@Composable
fun MovieCard(
    show: Tvshow,
    modifier: Modifier = Modifier,
    onClick: (Tvshow) -> Unit = {}
) {
    Card(
        onClick = { onClick(show)},
        modifier = modifier.widthIn(max = 220.dp)
    ) {
        Column {
            AsyncImage(
                model = show.image?.medium,
                contentDescription = show.name,
                modifier = Modifier
                    .fillMaxWidth() //agar tinggi gbr dpt sesuai
                    .height(280.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = show.name,
                maxLines = 1
            )

            Text(
                text = "⭐ ${show.rating?.average ?: "N/A"}"
            )
        }
    }
}