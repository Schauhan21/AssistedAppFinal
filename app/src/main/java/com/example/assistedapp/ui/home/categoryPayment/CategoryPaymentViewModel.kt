package com.example.assistedapp.ui.home.categoryPayment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assistedapp.Graph
import com.example.assistedapp.data.repository.PaymentRepository
import com.example.assistedapp.data.room.PaymentToCategory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class CategoryPaymentViewModel(
    private val categoryId: Long,
    private val paymentRepository: PaymentRepository = Graph.paymentRepository
) : ViewModel() {
    private val _state = MutableStateFlow(CategoryPaymentViewState())

    val state: StateFlow<CategoryPaymentViewState>
        get() = _state

    init {
        viewModelScope.launch {
            paymentRepository.paymentsInCategory(categoryId).collect { list ->
                _state.value = CategoryPaymentViewState(
                    payments = list
                )
            }
        }
    }
}

data class CategoryPaymentViewState(
    val payments: List<PaymentToCategory> = emptyList()
)