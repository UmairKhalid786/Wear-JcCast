package com.techlads.wearjccast.presentation.navigation

sealed class Screens(val title: String) {
    object LoginToken : Screens("login_token")
    object Home : Screens("home_screen")
}