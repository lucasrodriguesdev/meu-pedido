package br.com.lucasrodrigues.meupedido.data.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.lucasrodrigues.meupedido.data.models.Product

@Dao
interface ProductDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: Product)

    @Query("SELECT * FROM product_table")
    fun getAllProducts(): LiveData<List<Product>>
}