package com.example.tokopen.data.module

import com.example.tokopen.data.repository.PenRepositoryImpl
import com.example.tokopen.data.source.dummy.PenDummyObj
import com.example.tokopen.data.source.service.PenService
import com.example.tokopen.domain.repository.PenRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideDummyObject(): PenDummyObj {
        return PenDummyObj
    }

    @Singleton
    @Provides
    fun providePenService(dummyPenObj: PenDummyObj): PenService {
        return PenService(dummyPenObj)
    }

    @Singleton
    @Provides
    fun providePenRepository(penService: PenService): PenRepository {
        return PenRepositoryImpl(penService)
    }
}