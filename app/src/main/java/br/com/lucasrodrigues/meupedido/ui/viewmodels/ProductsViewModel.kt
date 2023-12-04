package br.com.lucasrodrigues.meupedido.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucasrodrigues.meupedido.data.models.Product
import br.com.lucasrodrigues.meupedido.data.repositories.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val repository: ProductRepository
) : ViewModel(){

    fun getAllProducts(): LiveData<List<Product>> {
        return repository.getAllProducts()
    }

    fun insertProduct(product: Product) = viewModelScope.launch {
        repository.insertProduct(product)
    }

}