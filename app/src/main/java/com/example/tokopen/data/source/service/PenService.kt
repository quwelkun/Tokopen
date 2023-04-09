package com.example.tokopen.data.source.service

import com.example.tokopen.data.source.dummy.PenDummyObj
import com.example.tokopen.data.source.response.PenResponse
import javax.inject.Inject

class PenService @Inject constructor(private val dummy: PenDummyObj) {

    fun getPens(): List<PenResponse> {
        return dummy.listPen.map {
            PenResponse(
                name = it.name,
                detail = it.detail,
                price = it.price,
                src = it.src
            )
        }
    }
}