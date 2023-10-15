package br.com.lucasrodrigues.meupedido.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import br.com.lucasrodrigues.meupedido.data.models.Product
import br.com.lucasrodrigues.meupedido.databinding.FragmentProductsBinding
import br.com.lucasrodrigues.meupedido.ui.viewmodels.ProductsViewModel

class ProductsFragment : Fragment(){

    lateinit var binding: FragmentProductsBinding
    val modalNewProductFragment = ModalNewProductFragment()
    val viewModel: ProductsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductsBinding.inflate(layoutInflater, container, false)
        setupObservers()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatingActionButton.setOnClickListener {
            modalNewProductFragment.show(parentFragmentManager, modalNewProductFragment.tag)
        }
    }

    private fun setupObservers(){
        viewModel.listOfProducts.observe(viewLifecycleOwner, Observer {
            for (prod in it){
                Log.d("LUCASRODRIGUES", prod.toString())
            }
        })
    }

    override fun onPause() {
        super.onPause()
        Log.d("LUCASRODRIGUES", "ONPAUSE")
    }

    override fun onStart() {
        super.onStart()
        Log.d("LUCASRODRIGUES", "ONSTART")
    }
}