package com.example.tokopen.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tokopen.domain.common.BaseResult
import com.example.tokopen.domain.model.Pen
import com.example.tokopen.domain.usecase.PenUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val penUseCases: PenUseCases) : ViewModel() {

    private val state = MutableStateFlow<HomeUiState>(HomeUiState.Init)
    val mState: StateFlow<HomeUiState> get() = state

    private val pens = MutableStateFlow<List<Pen>>(mutableListOf())
    val mPens: StateFlow<List<Pen>> get() = pens

    private fun setLoading() {
        state.value = HomeUiState.IsLoading(true)
    }

    private fun hideLoading() {
        state.value = HomeUiState.IsLoading(false)
    }

    private fun showToast(message: String) {
        state.value = HomeUiState.ShowToast(message)
    }

    fun fetchAllPens() {
        viewModelScope.launch {
            penUseCases.getPens()
                .onStart {
                    setLoading()
                }
                .catch { exception ->
                    hideLoading()
                    showToast(exception.message.toString())
                }
                .collect {result ->
                    hideLoading()
                    when(result) {
                        is BaseResult.Error -> {
                            showToast(result.message)
                        }
                        is BaseResult.Success -> pens.value = result.data
                    }
                }

        }
    }

}

sealed class HomeUiState {
    object Init : HomeUiState()
    data class IsLoading(val isLoading: Boolean) : HomeUiState()
    data class ShowToast(val message: String) : HomeUiState()
}