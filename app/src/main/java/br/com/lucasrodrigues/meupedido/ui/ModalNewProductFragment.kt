package br.com.lucasrodrigues.meupedido.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import br.com.lucasrodrigues.meupedido.data.models.Product
import br.com.lucasrodrigues.meupedido.databinding.FragmentModalNewProductBinding
import br.com.lucasrodrigues.meupedido.ui.viewmodels.ProductsViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ModalNewProductFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentModalNewProductBinding
    private val viewModel: ProductsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentModalNewProductBinding.inflate(layoutInflater,container, false)

        binding.btnSaveProduct.setOnClickListener {
            val product = Product(
                binding.tvProductName.editText?.text.toString(),
                binding.tvProductDescription.editText?.text.toString()
            )
            viewModel.insertProduct(product)
            dismiss()

        }
        return binding.root
    }

    companion object {
        const val TAG = "ModalBottomSheet"
    }

}