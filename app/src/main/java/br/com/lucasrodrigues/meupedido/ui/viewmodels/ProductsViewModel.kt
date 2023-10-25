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

    private val _listOfProducts = MutableLiveData<MutableList<Product>>()
    val listOfProducts: LiveData<MutableList<Product>>
        get() = _listOfProducts

    fun insertProduct(product: Product) = viewModelScope.launch {
        repository.insertProduct(product)
    }



    fun addNewProductToList(product: Product){
        val currentList = _listOfProducts.value ?: mutableListOf()
        currentList.add(product)
        _listOfProducts.postValue(
            currentList
        )
    }
    fun getLastProductId(): Long?{
        return if (_listOfProducts.value.isNullOrEmpty()) 0 else _listOfProducts.value?.last()?.id
    }


}