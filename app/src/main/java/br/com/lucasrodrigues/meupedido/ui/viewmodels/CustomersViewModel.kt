package br.com.lucasrodrigues.meupedido.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucasrodrigues.meupedido.data.models.Customer
import br.com.lucasrodrigues.meupedido.data.repositories.CustomerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CustomersViewModel @Inject constructor(
    private val repository: CustomerRepository
): ViewModel() {

    var customers = repository.getAllCustomers()

    fun insertCustomer(customer: Customer) = viewModelScope.launch {
        repository.insertCustomer(customer)
    }
    
}