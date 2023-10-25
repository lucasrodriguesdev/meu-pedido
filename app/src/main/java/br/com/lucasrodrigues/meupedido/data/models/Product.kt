package br.com.lucasrodrigues.meupedido.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
data class Product(
    var name: String? = null,
    var description: String? = null,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}