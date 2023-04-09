package com.example.tokopen.domain.repository

import com.example.tokopen.domain.common.BaseResult
import com.example.tokopen.domain.model.Pen
import kotlinx.coroutines.flow.Flow

interface PenRepository {

    suspend fun getPens(): Flow<BaseResult<List<Pen>, String>>

}