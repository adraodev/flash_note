package com.adrao.dev.flash_note.auth.di

import com.adrao.dev.flash_note.auth.domain.use_case.LoginUseCase

object AuthModule {
    val loginUseCase: LoginUseCase by lazy { LoginUseCase() }
}