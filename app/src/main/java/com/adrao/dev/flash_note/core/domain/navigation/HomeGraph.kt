package com.adrao.dev.flash_note.core.domain.navigation

import kotlinx.serialization.Serializable

@Serializable
data object HomeGraph {
    @Serializable
    data object NoteList

    @Serializable
    data class NoteDetail(val id: Int? = null)
}