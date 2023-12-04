package br.com.lucasrodrigues.meupedido.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import br.com.lucasrodrigues.meupedido.R
import br.com.lucasrodrigues.meupedido.adapters.ProductAdapter
import br.com.lucasrodrigues.meupedido.databinding.FragmentProductsBinding
import br.com.lucasrodrigues.meupedido.ui.viewmodels.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : Fragment(){

    private lateinit var binding: FragmentProductsBinding
    private val modalNewProductFragment = NewProductFragment()
    private val viewModel: ProductsViewModel by viewModels()

    private lateinit var productAdapter: ProductAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductsBinding.inflate(layoutInflater, container, false)
        setupRecyclerView()
        setupObservers()

        binding.fabNewProduct.setOnClickListener {
            findNavController().navigate(R.id.action_productsFragment_to_newProductFragment)
        }

        return binding.root
    }

    private fun setupRecyclerView(){
        productAdapter = ProductAdapter(emptyList())
        binding.rvListProducts.adapter = productAdapter
    }

    private fun setupObservers(){
        viewModel.getAllProducts().observe(viewLifecycleOwner, Observer {
            productAdapter.updateData(it)
        })
    }
}