package com.riveong.teaapp.ui.navigation


sealed class Screen(val route: String) {
    object Home : Screen("home")
    object AboutMe : Screen("aboutme")
    object DetailSigma : Screen("home/{sigmaID}") {
        fun createRoute(sigmaID: Long) = "home/$sigmaID"
    }
}
