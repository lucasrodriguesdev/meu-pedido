package br.com.lucasrodrigues.meupedido.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.com.lucasrodrigues.meupedido.R
import br.com.lucasrodrigues.meupedido.data.models.Customer
import br.com.lucasrodrigues.meupedido.databinding.FragmentNewCustomerBinding
import br.com.lucasrodrigues.meupedido.ui.viewmodels.CustomersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewCustomerFragment : Fragment() {

    private lateinit var binding: FragmentNewCustomerBinding
    private val viewModel: CustomersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewCustomerBinding.inflate(layoutInflater,container, false)

        binding.btnSaveCustomer.setOnClickListener {
            val customer = Customer(
                binding.tvCustomerName.editText?.text.toString(),
                binding.tvCustomerEmail.editText?.text.toString()
            )
            viewModel.insertCustomer(customer)

            findNavController().navigate(R.id.action_modalNewCustomerFragment_to_customersFragment)

        }
        return binding.root
    }



}