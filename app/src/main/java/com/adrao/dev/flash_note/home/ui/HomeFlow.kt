package com.adrao.dev.flash_note.home.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adrao.dev.flash_note.core.domain.navigation.HomeGraph
import com.adrao.dev.flash_note.core.domain.navigation.HomeGraph.NoteDetail
import com.adrao.dev.flash_note.core.domain.navigation.HomeGraph.NoteList

@Composable
fun HomeFlow() {
    val homeNavController = rememberNavController()
    NavHost(
        navController = homeNavController,
        startDestination = NoteList,
        route = HomeGraph::class
    ) {
        composable<NoteList> {
            /*NoteListScreen(
                onNoteClick = { id -> homeNavController.navigate(HomeGraph.NoteDetail(id)) },
                onAddNoteClick = { homeNavController.navigate(HomeGraph.NoteDetail()) }
            )*/
        }
        composable<NoteDetail> { backStackEntry ->
            /*NoteDetailScreen(
                id = backStackEntry.arguments?.getInt("id"),
                onBack = { homeNavController.popBackStack() }
            )*/
        }
    }
}