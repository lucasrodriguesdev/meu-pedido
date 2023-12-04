package br.com.lucasrodrigues.meupedido.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import br.com.lucasrodrigues.meupedido.adapters.CustomerAdapter
import br.com.lucasrodrigues.meupedido.databinding.FragmentCustomersBinding
import br.com.lucasrodrigues.meupedido.ui.viewmodels.CustomersViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CustomersFragment : Fragment() {

    private lateinit var binding: FragmentCustomersBinding
    private val modalNewCustomerFragment = ModalNewCustomerFragment()

    private val viewlModel: CustomersViewModel by viewModels()

    private lateinit var customerAdapter: CustomerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCustomersBinding.inflate(layoutInflater, container, false)

        setupRecyclerView()
        setupObservers()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabNewCustomer.setOnClickListener {
            modalNewCustomerFragment.show(parentFragmentManager, modalNewCustomerFragment.tag)
        }
    }

    private fun setupRecyclerView(){
        customerAdapter = CustomerAdapter(emptyList())
        binding.rvListCustomers.adapter = customerAdapter
    }

    private fun setupObservers(){
        viewlModel.customers.observe(viewLifecycleOwner, Observer {
            customerAdapter.updateDate(it)
        })
    }

}