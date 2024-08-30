package com.adrao.dev.flash_note.auth.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adrao.dev.flash_note.auth.ui.login.LoginScreen
import com.adrao.dev.flash_note.core.domain.navigation.AuthGraph
import com.adrao.dev.flash_note.core.domain.navigation.ForgotPassword
import com.adrao.dev.flash_note.core.domain.navigation.Login
import com.adrao.dev.flash_note.core.domain.navigation.Register

@Composable
fun AuthFlow(onLoginSuccess: () -> Unit) {
    val authNavController = rememberNavController()
    Scaffold {
        NavHost(
            modifier = Modifier.padding(top = it.calculateTopPadding(), bottom = it.calculateBottomPadding()),
            navController = authNavController,
            startDestination = Login,
            route = AuthGraph::class
        ) {
            composable<Login> {
                LoginScreen(
                    onLoginSuccess = onLoginSuccess,
                    onNavigate = {
                        authNavController.navigate(it)
                    })
            }
            composable<Register> {

            }
            composable<ForgotPassword> {

            }
        }
    }
}