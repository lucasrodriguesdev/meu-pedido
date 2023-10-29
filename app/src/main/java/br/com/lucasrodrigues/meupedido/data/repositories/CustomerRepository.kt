package br.com.lucasrodrigues.meupedido.data.repositories

import br.com.lucasrodrigues.meupedido.data.daos.CustomerDAO
import br.com.lucasrodrigues.meupedido.data.models.Customer
import javax.inject.Inject

class CustomerRepository @Inject constructor(
    private val customerDAO: CustomerDAO
){
    suspend fun insertCustomer(customer: Customer) =
        customerDAO.insertCustomer(customer)

    fun getAllCustomers() = customerDAO.getAllCustomers()

}