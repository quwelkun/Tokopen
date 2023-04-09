package com.example.tokopen.domain.usecase

import com.example.tokopen.domain.common.BaseResult
import com.example.tokopen.domain.model.Pen
import com.example.tokopen.domain.repository.PenRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class PenInteractor @Inject constructor(private val penRepository: PenRepository): PenUseCases {
    override suspend fun getPens(): Flow<BaseResult<List<Pen>, String>> {
        return penRepository.getPens()
    }
}