package com.zamswork.notekeeper.presentation.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {

    val navHostController = rememberNavController()
    val startDestination = Route.HomeScreenRoute.name

    NavHost(navController = navHostController, startDestination = startDestination){
        composable(route = startDestination){
            NotesList{
                navHostController.navigate(Route.CreateNoteScreenRoute.name)
            }
        }

        composable(route = Route.CreateNoteScreenRoute.name){
            CreateNoteScreen()
        }

    }
}

sealed class Route(val name : String){
    data object HomeScreenRoute : Route(name = "home")
    data object CreateNoteScreenRoute : Route(name = "create_note")
}