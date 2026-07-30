package com.ayuk.tvapp.ui.screen.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ayuk.tvapp.data.model.Tvshow
import com.ayuk.tvapp.ui.component.MovieCard

@Composable
fun ListScreen(
    viewModel: ListViewModel,
    onShowClick: (Tvshow) -> Unit
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {

        is ListUiState.Loading -> {

            CircularProgressIndicator()

        }

        is ListUiState.Error -> {

            Text("Failed to load")

        }

        is ListUiState.Success -> {

            val shows =
                (uiState as ListUiState.Success).shows

            LazyVerticalGrid(
                columns = GridCells.Fixed(5),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
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