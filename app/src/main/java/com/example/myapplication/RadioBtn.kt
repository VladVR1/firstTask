package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentRadioBtnBinding

class RadioBtn : Fragment() {

    private lateinit var binding: FragmentRadioBtnBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentRadioBtnBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProvider(requireActivity())[ViewModelFragment::class.java]

        binding.btnNextFragmentRadio.setOnClickListener{

        findNavController().navigate(R.id.action_radioBtn_to_checkbox2)
        }
        binding.btnBackFragmentRadio.setOnClickListener{
            findNavController().popBackStack()
        }
    }


}