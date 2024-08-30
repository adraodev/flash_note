package com.adrao.dev.flash_note.core.domain.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.adrao.dev.flash_note.core.domain.navigation.AuthGraph
import com.adrao.dev.flash_note.core.domain.navigation.HomeGraph

@Composable
fun RootNavHost(modifier: Modifier = Modifier, rootNavHostController: NavHostController) {
    NavHost(navController = rootNavHostController, startDestination = AuthGraph) {
        composable<AuthGraph> {
            /*AuthNavHost(rootNavHostController)*/
        }
        composable<HomeGraph> {
            /*HomeNavHost(onClickLogout = {})*/
        }
    }
}