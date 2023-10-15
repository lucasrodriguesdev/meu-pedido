package br.com.lucasrodrigues.meupedido.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import br.com.lucasrodrigues.meupedido.R
import br.com.lucasrodrigues.meupedido.data.models.Product
import br.com.lucasrodrigues.meupedido.databinding.FragmentModalNewProductBinding
import br.com.lucasrodrigues.meupedido.ui.viewmodels.ProductsViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ModalNewProductFragment : BottomSheetDialogFragment() {

    lateinit var binding: FragmentModalNewProductBinding
    val viewModel: ProductsViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentModalNewProductBinding.inflate(layoutInflater,container, false)

        binding.btnSaveProduct.setOnClickListener {
            val product = Product(
                viewModel.getLastProductId()?.plus(1),
                binding.tvProductName.editText?.text.toString(),
                binding.tvProductDescription.editText?.text.toString()
            )
            viewModel.addNewProductToList(product)
            dismiss()
        }

        return binding.root
    }


    companion object {
        const val TAG = "ModalBottomSheet"
    }


}