package com.ayuk.tvapp.ui.screen.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ayuk.tvapp.data.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ListViewModel(
    private val repository: Repository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<ListUiState>(ListUiState.Loading)

    val uiState: StateFlow<ListUiState> = _uiState

    init {
        getShows()
    }

    private fun getShows() {
        viewModelScope.launch {

            try {

                val shows = repository.getShows()

                _uiState.value =
                    ListUiState.Success(shows)

            } catch (e: Exception) {

                _uiState.value =
                    ListUiState.Error(e.message ?: "Unknown Error")

            }

        }
    }

}