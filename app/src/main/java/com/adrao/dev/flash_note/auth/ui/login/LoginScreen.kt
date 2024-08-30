package com.adrao.dev.flash_note.auth.ui.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adrao.dev.flash_note.auth.di.AuthModule
import com.adrao.dev.flash_note.core.domain.navigation.AuthGraph
import com.adrao.dev.flash_note.core.domain.navigation.ForgotPassword
import com.adrao.dev.flash_note.core.ui.components.CustomButton
import com.adrao.dev.flash_note.core.ui.components.CustomTextField

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = LoginViewModel(AuthModule.loginUseCase), onNavigate: (AuthGraph) -> Unit, onLoginSuccess: () -> Unit
) {
    if (viewModel.uiState().isLoggedIn) {
        onLoginSuccess()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp), contentAlignment = Alignment.Center
    ) {

        Column {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                CustomTextField(modifier = Modifier.fillMaxWidth(),
                    value = viewModel.uiState().email,
                    onValueChange = { viewModel.onEvent(LoginEvent.EmailChanged(it)) },
                    label = { Text("Email") })
                CustomTextField(modifier = Modifier.fillMaxWidth(),
                    value = viewModel.uiState().password,
                    onValueChange = { viewModel.onEvent(LoginEvent.PasswordChanged(it)) },
                    label = { Text("Password") })
                viewModel.uiState().errorMessage?.let {
                    Text(text = it, fontSize = 10.sp, color = androidx.compose.ui.graphics.Color.Red)
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp), verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(text = "Forgot password?", fontSize = 10.sp, modifier = Modifier
                    .align(Alignment.End)
                    .clickable {
                        onNavigate(ForgotPassword)
                    })
                CustomButton(modifier = Modifier
                    .fillMaxWidth(.5f)
                    .align(Alignment.CenterHorizontally),
                    onClick = { viewModel.onEvent(LoginEvent.LoginClicked) }) {
                    Text(text = "Login")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(viewModel = LoginViewModel(AuthModule.loginUseCase), onNavigate = {}, onLoginSuccess = {})
}