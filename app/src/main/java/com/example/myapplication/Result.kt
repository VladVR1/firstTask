package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentResultBinding

class Result : Fragment() {

    private lateinit var binding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model = ViewModelProvider(requireActivity())[ViewModelFragment::class.java]
        model.userInput.observe(viewLifecycleOwner, Observer {
            binding.result.text = it
        })
        model.radioBtnAnswer.observe(viewLifecycleOwner, Observer {
            binding.result.text = it
        })
        model.checkBoxAnswer.observe(viewLifecycleOwner, Observer {
            binding.result.text = it
        })
    }
}