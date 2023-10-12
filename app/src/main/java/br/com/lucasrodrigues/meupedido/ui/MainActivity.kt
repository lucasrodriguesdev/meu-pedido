package br.com.lucasrodrigues.meupedido.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import br.com.lucasrodrigues.meupedido.R
import br.com.lucasrodrigues.meupedido.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navHostFragment: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navHostFragment = findNavController(R.id.navHostFragment)
        setSupportActionBar(binding.topAppBar)
        binding.bottomNavigation.setupWithNavController(navHostFragment)
    }
}