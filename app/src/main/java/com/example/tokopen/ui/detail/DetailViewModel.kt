package com.example.tokopen.ui.detail

import android.content.Intent
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(): ViewModel() {

    var name: String? = null
    var price: String? = null
    var desc: String? = null
    var src: Int? = 0


    fun processIntent(intent: Intent) {
        with(intent) {
            name = getStringExtra(DetailPenActivity.NAME)
            price = getStringExtra(DetailPenActivity.PRICE)
            desc = getStringExtra(DetailPenActivity.DETAIL)
            src = getIntExtra(DetailPenActivity.SRC, 0)
        }
    }


}