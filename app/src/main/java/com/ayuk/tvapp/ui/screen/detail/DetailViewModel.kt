package com.ayuk.tvapp.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ayuk.tvapp.data.Repository
import com.ayuk.tvapp.data.model.Tvshow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: Repository
) : ViewModel() {

    private val _tvShow = MutableStateFlow<Tvshow?>(null)
    val tvShow: StateFlow<Tvshow?> = _tvShow

    fun getDetail(id: Int) {
        viewModelScope.launch {
            try {
                _tvShow.value = repository.getShowDetail(id)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}