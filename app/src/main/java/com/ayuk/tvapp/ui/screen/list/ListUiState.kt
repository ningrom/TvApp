package com.ayuk.tvapp.ui.screen.list

import com.ayuk.tvapp.data.model.Tvshow

sealed class ListUiState{
    object Loading : ListUiState()

    data class Success(
        val shows: List<Tvshow>
    ) : ListUiState()

    data class Error(
        val message: String
    ) : ListUiState()
}
