package com.zamswork.notekeeper.domain.usecase

interface SuspendUseCase<Input, Output>{
    suspend operator fun invoke(input : Input) : Output

}