package com.adrao.dev.flash_note.auth.ui.login

import androidx.compose.runtime.Immutable

@Immutable
data class LoginState(
    val email: String, val password: String, val errorMessage: String? = null, val isLoggedIn: Boolean
)