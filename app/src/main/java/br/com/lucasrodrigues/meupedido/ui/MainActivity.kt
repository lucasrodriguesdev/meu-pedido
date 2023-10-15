package br.com.lucasrodrigues.meupedido.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import br.com.lucasrodrigues.meupedido.R
import br.com.lucasrodrigues.meupedido.databinding.ActivityMainBinding
import br.com.lucasrodrigues.meupedido.ui.viewmodels.ProductsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navHostFragment: NavController
    val viewModel: ProductsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navHostFragment = findNavController(R.id.navHostFragment)
        setSupportActionBar(binding.topAppBar)
        binding.bottomNavigation.setupWithNavController(navHostFragment)
    }
}