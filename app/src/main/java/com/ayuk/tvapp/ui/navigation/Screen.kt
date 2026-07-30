package com.ayuk.tvapp.ui.navigation

sealed class Screen(val route: String) {
    object List : Screen("list")

    object Detail : Screen("detail/{showId}") {

        fun createRoute(showId: Int): String {
            return "detail/$showId"
        }
    }
}