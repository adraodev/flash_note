package com.adrao.dev.flash_note.core.domain.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.adrao.dev.flash_note.auth.ui.AuthFlow
import com.adrao.dev.flash_note.core.domain.navigation.AuthGraph
import com.adrao.dev.flash_note.core.domain.navigation.HomeGraph
import com.adrao.dev.flash_note.home.ui.HomeFlow

@Composable
fun RootNavHost(modifier: Modifier = Modifier, rootNavHostController: NavHostController) {
    NavHost(navController = rootNavHostController, startDestination = AuthGraph::class) {
        composable<AuthGraph> {
            AuthFlow {
                rootNavHostController.navigate(HomeGraph)
            }
        }
        composable<HomeGraph> {
            /*HomeNavHost(onClickLogout = {})*/
            HomeFlow()
        }
    }
}