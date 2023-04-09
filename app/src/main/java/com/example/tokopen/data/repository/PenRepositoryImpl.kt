package com.example.tokopen.data.repository

import com.example.tokopen.data.source.service.PenService
import com.example.tokopen.domain.common.BaseResult
import com.example.tokopen.domain.model.Pen
import com.example.tokopen.domain.repository.PenRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PenRepositoryImpl @Inject constructor(
    private val service: PenService
) : PenRepository {

    override suspend fun getPens(): Flow<BaseResult<List<Pen>, String>> {
        return flow {
            val response = service.getPens()
            val pens = mutableListOf<Pen>()
            if (response.isNotEmpty()) {
                response.forEach {
                    pens.add(
                        Pen(
                            name = it.name.toString(),
                            detail = it.detail.toString(),
                            price = it.price.toString(),
                            src = it.src!!
                        )
                    )
                }
                emit(BaseResult.Success(pens))
            } else {
                emit(BaseResult.Error("Pens is Empty"))
            }
        }
    }
}