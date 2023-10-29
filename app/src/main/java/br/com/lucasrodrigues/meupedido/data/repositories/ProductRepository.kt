package br.com.lucasrodrigues.meupedido.data.repositories

import br.com.lucasrodrigues.meupedido.data.daos.ProductDAO
import br.com.lucasrodrigues.meupedido.data.models.Product
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productDAO: ProductDAO
) {
    suspend fun insertProduct(product: Product) =
        productDAO.insertProduct(product)

    fun getAllProducts() = productDAO.getAllProducts()

}