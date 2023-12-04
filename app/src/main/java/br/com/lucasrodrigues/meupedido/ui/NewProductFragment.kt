package br.com.lucasrodrigues.meupedido.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.com.lucasrodrigues.meupedido.R
import br.com.lucasrodrigues.meupedido.data.models.Product
import br.com.lucasrodrigues.meupedido.databinding.FragmentNewProductBinding
import br.com.lucasrodrigues.meupedido.ui.viewmodels.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewProductFragment : Fragment() {

    private lateinit var binding: FragmentNewProductBinding
    private val viewModel: ProductsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewProductBinding.inflate(layoutInflater,container, false)

        binding.btnSaveProduct.setOnClickListener {
            val product = Product(
                binding.tvProductName.editText?.text.toString(),
                binding.tvProductDescription.editText?.text.toString()
            )
            viewModel.insertProduct(product)

            findNavController().navigate(R.id.action_newProductFragment_to_productsFragment)

        }
        return binding.root
    }

}