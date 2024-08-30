package com.adrao.dev.flash_note.core.domain.navigation

import kotlinx.serialization.Serializable

@Serializable
data object AuthGraph {
    @Serializable
    data object Login

    @Serializable
    data object Register

    @Serializable
    data object ForgotPassword
}