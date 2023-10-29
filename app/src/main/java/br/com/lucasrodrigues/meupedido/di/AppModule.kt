package br.com.lucasrodrigues.meupedido.di

import android.content.Context
import androidx.room.Room
import br.com.lucasrodrigues.meupedido.data.OrdersDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideOrderDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        OrdersDatabase::class.java,
        "orders_db"
    ).build()

    @Provides
    fun provideProductDao(db: OrdersDatabase) = db.getProductDao()


    @Provides
    fun provideCustomerDao(db: OrdersDatabase) = db.getCustomerDao()
}