package com.zamswork.notekeeper.domain.usecase

interface UseCase<Input, Output> {

    operator fun invoke(input: Input):Output

}