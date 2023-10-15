package br.com.lucasrodrigues.meupedido.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.lucasrodrigues.meupedido.data.models.Product

class ProductsViewModel : ViewModel(){

    private val _listOfProducts = MutableLiveData<MutableList<Product>>()
    val listOfProducts: LiveData<MutableList<Product>>
        get() = _listOfProducts

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