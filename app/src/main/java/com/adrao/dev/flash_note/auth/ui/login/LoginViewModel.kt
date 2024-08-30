package com.adrao.dev.flash_note.auth.ui.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewModelScope
import com.adrao.dev.flash_note.auth.domain.use_case.LoginUseCase
import com.adrao.dev.flash_note.core.domain.util.ComposeViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@Stable
class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ComposeViewModel<LoginState, LoginEvent>() {
    private val email: SharedFlow<String>
        field = MutableSharedFlow<String>()
    private val password: SharedFlow<String>
        field = MutableSharedFlow<String>()
    private val errorMessage = MutableStateFlow<String?>(null)
    private val isLoggedIn = MutableStateFlow(false)

    lateinit var loginState: LoginState

    @Composable
    override fun uiState(): LoginState {
        loginState = LoginState(
            email = email.collectAsState("").value,
            password = password.collectAsState("").value,
            errorMessage = errorMessage.collectAsState().value,
            isLoggedIn = isLoggedIn.collectAsState().value
        )
        return loginState
    }

    override fun onEvent(event: LoginEvent) {
        viewModelScope.launch {
            when (event) {
                is LoginEvent.EmailChanged -> email.emit(event.email)
                is LoginEvent.PasswordChanged -> password.emit(event.password)
                is LoginEvent.LoginClicked -> evaluateLogin()
            }
        }
    }

    private fun evaluateLogin() {
        viewModelScope.launch {
            loginUseCase.invoke(loginState.email, loginState.password).onLeft {
                errorMessage.update { it ?: "An error occurred" }
            }.onRight {
                isLoggedIn.update { true }
            }
        }
    }

}