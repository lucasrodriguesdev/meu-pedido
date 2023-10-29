package br.com.lucasrodrigues.meupedido.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import br.com.lucasrodrigues.meupedido.data.models.Customer
import br.com.lucasrodrigues.meupedido.databinding.FragmentModalNewCustomerBinding
import br.com.lucasrodrigues.meupedido.ui.viewmodels.CustomersViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ModalNewCustomerFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentModalNewCustomerBinding
    private val viewModel: CustomersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentModalNewCustomerBinding.inflate(layoutInflater,container, false)

        binding.btnSaveCustomer.setOnClickListener {
            val customer = Customer(
                binding.tvCustomerName.editText?.text.toString(),
                binding.tvCustomerEmail.editText?.text.toString()
            )
            viewModel.insertCustomer(customer)
            dismiss()

        }
        return binding.root
    }

    companion object {
        const val TAG = "ModalBottomSheet"
    }


}