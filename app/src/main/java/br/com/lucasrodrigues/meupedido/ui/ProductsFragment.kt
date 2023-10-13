package br.com.lucasrodrigues.meupedido.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.lucasrodrigues.meupedido.databinding.FragmentProductsBinding

class ProductsFragment : Fragment(){

    private lateinit var binding: FragmentProductsBinding
    private val modalNewProductFragment = ModalNewProductFragment()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatingActionButton.setOnClickListener {
            modalNewProductFragment.show(parentFragmentManager, modalNewProductFragment.tag)
        }
    }

}