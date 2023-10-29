package br.com.lucasrodrigues.meupedido.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.lucasrodrigues.meupedido.databinding.FragmentCustomersBinding


class CustomersFragment : Fragment() {

    private lateinit var binding: FragmentCustomersBinding
    private val modalNewCustomerFragment = ModalNewCustomerFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCustomersBinding.inflate(layoutInflater, container, false)
        binding.floatingActionButton.setOnClickListener {
            modalNewCustomerFragment.show(parentFragmentManager, modalNewCustomerFragment.tag)
        }

        return binding.root
    }

}