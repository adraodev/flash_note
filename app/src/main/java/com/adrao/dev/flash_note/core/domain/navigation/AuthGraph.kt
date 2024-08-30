package com.adrao.dev.flash_note.core.domain.navigation

import kotlinx.serialization.Serializable

@Serializable
open class AuthGraph

@Serializable
object Login : AuthGraph()

@Serializable
object Register : AuthGraph()

@Serializable
object ForgotPassword : AuthGraph()