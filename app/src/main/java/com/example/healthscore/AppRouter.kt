package com.example.healthscore

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen{
    object welcome_screen:Screen()
    object sign_up_patient:Screen()
    object sign_in_patient:Screen()
    object sign_up_hospital:Screen()
    object sign_in_hospital:Screen()

}
object AppRouter{
    var currentScreen:MutableState<Screen> = mutableStateOf(Screen.welcome_screen)

    fun navigateTo(destination: Screen){
        currentScreen.value=destination
    }
}