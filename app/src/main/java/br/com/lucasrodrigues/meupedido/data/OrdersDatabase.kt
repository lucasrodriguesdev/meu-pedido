package br.com.lucasrodrigues.meupedido.data

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.lucasrodrigues.meupedido.data.daos.ProductDAO
import br.com.lucasrodrigues.meupedido.data.models.Customer
import br.com.lucasrodrigues.meupedido.data.models.ItemOrder
import br.com.lucasrodrigues.meupedido.data.models.Order
import br.com.lucasrodrigues.meupedido.data.models.Product

@Database(
    entities = [
        Product::class
    ],
    version = 1,
    exportSchema = false
)
abstract class OrdersDatabase : RoomDatabase() {
    abstract fun getProductDao(): ProductDAO

}