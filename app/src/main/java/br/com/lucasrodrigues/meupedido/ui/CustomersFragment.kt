package br.com.lucasrodrigues.meupedido.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.lucasrodrigues.meupedido.R
import br.com.lucasrodrigues.meupedido.databinding.FragmentCustomersBinding


class CustomersFragment : Fragment() {

    private lateinit var binding: FragmentCustomersBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCustomersBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}