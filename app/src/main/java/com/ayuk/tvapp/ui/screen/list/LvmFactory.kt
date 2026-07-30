package com.ayuk.tvapp.ui.screen.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ayuk.tvapp.data.Repository

class LvmFactory (
    private val repository: Repository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
            return ListViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel")
    }
}