package com.ayuk.tvapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
//import androidx.tv.material3.Text
//import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
//import androidx.compose.ui.tooling.preview.Preview
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import com.ayuk.tvapp.data.Repository
import com.ayuk.tvapp.data.api.ApiConfig
import com.ayuk.tvapp.ui.screen.list.ListScreen
import com.ayuk.tvapp.ui.screen.list.ListViewModel
import com.ayuk.tvapp.ui.screen.list.LvmFactory
import com.ayuk.tvapp.ui.theme.TvappTheme

class MainActivity : ComponentActivity() {

    private val viewModel: ListViewModel by viewModels {

        LvmFactory(
            Repository(
                ApiConfig.apiService
            )
        )
    }
    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TvappTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    shape = RectangleShape
                ) {
                    ListScreen(
                        viewModel = viewModel,

                        onShowClick = {
                        }
                    )
                }
            }
        }
    }
}
