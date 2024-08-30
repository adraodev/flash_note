package com.adrao.dev.flash_note.auth.domain.use_case

import com.adrao.dev.flash_note.auth.domain.exception.EmailInvalidException
import com.adrao.dev.flash_note.auth.domain.exception.EmailOrPasswordEmptyException
import com.adrao.dev.flash_note.auth.domain.exception.PasswordInvalidException

class LoginUseCase() {
    suspend operator fun invoke(email: String, password: String): Either<Exception, Unit> {
        if (email.isEmpty() || password.isEmpty()) {
            return Either.Left(EmailOrPasswordEmptyException())
        }

        if (email.length < 5) {
            return Either.Left(EmailInvalidException())
        }

        if (password.length < 5) {
            return Either.Left(PasswordInvalidException())
        }

        return Either.Right(Unit)
    }
}

sealed class Either<out L, out R> {
    data class Left<out L>(val value: L) : Either<L, Nothing>()
    data class Right<out R>(val value: R) : Either<Nothing, R>()

    fun <L> left(value: L) = Left(value)
    fun <R> right(value: R) = Right(value)

    fun onLeft(action: (L) -> Unit): Either<L, R> {
        if (this is Left) {
            action(value)
        }
        return this
    }

    fun onRight(action: (R) -> Unit): Either<L, R> {
        if (this is Right) {
            action(value)
        }
        return this
    }

}