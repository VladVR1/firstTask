package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentCheckboxBinding

class Checkbox : Fragment() {

    private lateinit var binding: FragmentCheckboxBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCheckboxBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProvider(requireActivity())[ViewModelFragment::class.java]


        binding.btnNextFragmentCheckBox.setOnClickListener{

            findNavController().navigate(R.id.action_checkbox2_to_result)
        }
        binding.btnBackFragmentCheckBox.setOnClickListener{

            findNavController().popBackStack()
        }
    }
}