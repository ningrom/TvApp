package com.ayuk.tvapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import com.ayuk.tvapp.data.Repository
import com.ayuk.tvapp.data.api.ApiConfig
import com.ayuk.tvapp.ui.navigation.Screen
import com.ayuk.tvapp.ui.screen.detail.DetailScreen
import com.ayuk.tvapp.ui.screen.detail.DetailViewModel
import com.ayuk.tvapp.ui.screen.detail.DetailVmFactory
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
    private val detailViewModel: DetailViewModel by viewModels {
        DetailVmFactory(
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
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    shape = RectangleShape
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Screen.List.route
                    ){
                        composable(Screen.List.route){

                            ListScreen(
                                viewModel = viewModel,
                                onShowClick = { show ->
                                    Log.d("NAV", "Navigating to detail with id=${show.id}")
                                    navController.navigate(
                                        Screen.Detail.createRoute(show.id))
                                }
                            )
                        }
                        composable(
                            route = Screen.Detail.route
                        ){ backStackEntry ->

                            val showId = backStackEntry.arguments
                                ?.getString("showId")
                                ?.toIntOrNull()

                            if (showId != null){
                                DetailScreen(
                                    showId = showId,
                                    viewModel = detailViewModel
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
