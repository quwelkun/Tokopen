package com.example.tokopen.domain.usecase

import com.example.tokopen.domain.common.BaseResult
import com.example.tokopen.domain.model.Pen
import kotlinx.coroutines.flow.Flow

interface PenUseCases {
    suspend fun getPens(): Flow<BaseResult<List<Pen>,String>>
}