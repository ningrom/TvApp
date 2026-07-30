package com.ayuk.tvapp.ui.screen.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ayuk.tvapp.data.model.Tvshow
import com.ayuk.tvapp.ui.component.MovieCard

@Composable
fun ListScreen(
    viewModel: ListViewModel,
    onShowClick: (Tvshow) -> Unit,
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Column {
        Text(
            text = "TV Shows",
            style = MaterialTheme.typography.headlineMedium
        )
        when (uiState) {

            is ListUiState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is ListUiState.Error -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Failed to load")
                }
            }

            is ListUiState.Success -> {

                val shows =
                    (uiState as ListUiState.Success).shows

                LazyVerticalGrid(
                    columns = GridCells.Fixed(5),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(24.dp)
                ) {

                    items(shows) { show ->

                        MovieCard(

                            show = show,

                            onClick = {
                                onShowClick(show)
                            }
                        )
                    }
                }
            }
        }
    }
}