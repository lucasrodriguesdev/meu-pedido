package br.com.lucasrodrigues.meupedido.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.lucasrodrigues.meupedido.adapters.ProductAdapter
import br.com.lucasrodrigues.meupedido.databinding.FragmentProductsBinding
import br.com.lucasrodrigues.meupedido.ui.viewmodels.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : Fragment(){

    private lateinit var binding: FragmentProductsBinding
    private val modalNewProductFragment = ModalNewProductFragment()
    private val viewModel: ProductsViewModel by viewModels()

    private lateinit var productAdapter: ProductAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductsBinding.inflate(layoutInflater, container, false)
        setupRecyclerView()
        setupObservers()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabNewProduct.setOnClickListener {
            modalNewProductFragment.show(parentFragmentManager, modalNewProductFragment.tag)
        }
    }

    private fun setupRecyclerView(){
        productAdapter = ProductAdapter(emptyList())
        binding.rvListProducts.adapter = productAdapter
    }

    private fun setupObservers(){
        viewModel.products.observe(viewLifecycleOwner, Observer {
            productAdapter.updateData(it)
        })
    }
}