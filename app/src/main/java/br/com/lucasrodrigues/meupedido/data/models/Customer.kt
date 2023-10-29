package br.com.lucasrodrigues.meupedido.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customers_table")
data class Customer(
    val name: String? = null,
    val email: String? = null
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}