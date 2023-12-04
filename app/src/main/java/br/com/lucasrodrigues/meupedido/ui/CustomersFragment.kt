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
import br.com.lucasrodrigues.meupedido.adapters.CustomerAdapter
import br.com.lucasrodrigues.meupedido.databinding.FragmentCustomersBinding
import br.com.lucasrodrigues.meupedido.ui.viewmodels.CustomersViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CustomersFragment : Fragment() {

    private lateinit var binding: FragmentCustomersBinding
    private val newCustomerFragment = NewCustomerFragment()

    private val viewlModel: CustomersViewModel by viewModels()

    private lateinit var customerAdapter: CustomerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCustomersBinding.inflate(layoutInflater, container, false)

        setupRecyclerView()
        setupObservers()

        binding.fabNewCustomer.setOnClickListener {
            findNavController().navigate(R.id.action_customersFragment_to_modalNewCustomerFragment)
        }

        return binding.root
    }

    private fun setupRecyclerView(){
        customerAdapter = CustomerAdapter(emptyList())
        binding.rvListCustomers.adapter = customerAdapter
    }

    private fun setupObservers(){
        viewlModel.getAllCustomers().observe(viewLifecycleOwner, Observer {
            customerAdapter.updateDate(it)
        })
    }


}