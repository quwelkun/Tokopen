package com.example.tokopen.domain.module

import com.example.tokopen.domain.repository.PenRepository
import com.example.tokopen.domain.usecase.PenInteractor
import com.example.tokopen.domain.usecase.PenUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Singleton
    @Provides
    fun providePenUseCase(penRepository: PenRepository): PenUseCases {
        return PenInteractor(penRepository)
    }

}