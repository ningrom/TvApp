package com.ayuk.tvapp.ui.screen.detail

import android.text.Html
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun DetailScreen(
    showId: Int,
    viewModel: DetailViewModel,
    modifier: Modifier = Modifier
) {

    LaunchedEffect(showId) {
        viewModel.getDetail(showId)
    }

    val tvShow by viewModel.tvShow.collectAsState()
    if (tvShow == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Loading...")
        }
        return
    }

    val summary = Html.fromHtml(
        tvShow!!.summary ?: "",
        Html.FROM_HTML_MODE_COMPACT
    ).toString()

    Box(
        modifier = modifier.fillMaxSize()
    ) {

        AsyncImage(
            model = tvShow!!.image?.original,
            contentDescription = tvShow!!.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            MaterialTheme.colorScheme.background
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(40.dp)
                .fillMaxWidth(0.6f)
                .verticalScroll(rememberScrollState())
        ) {

            Text(
                text = tvShow!!.name,
                style = MaterialTheme.typography.displaySmall
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Premiered: ${tvShow!!.premiered ?: "-"}",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = summary,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}