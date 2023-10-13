package br.com.lucasrodrigues.meupedido.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.lucasrodrigues.meupedido.R
import br.com.lucasrodrigues.meupedido.databinding.FragmentModalNewProductBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ModalNewProductFragment : BottomSheetDialogFragment() {

    lateinit var binding: FragmentModalNewProductBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentModalNewProductBinding.inflate(layoutInflater,container, false)
        binding.btnSaveProduct.setOnClickListener {
            dismiss()
        }
        return binding.root
    }

    companion object {
        const val TAG = "ModalBottomSheet"
    }


}