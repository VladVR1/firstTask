package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentInputUserBinding


class InputUser : Fragment() {

    private lateinit var binding: FragmentInputUserBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentInputUserBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val model = ViewModelProvider(requireActivity())[ViewModelFragment::class.java]

        binding.firstBtnName.setOnClickListener {

            if (binding.userAnswer.text.isEmpty()) {
                Toast.makeText(activity, R.string.empty_answer, Toast.LENGTH_LONG).show()
            } else {
                    model.setDataUserInput(binding.userAnswer.text.toString())
                    findNavController().navigate(R.id.action_nameUser_to_radioBtn)
                }
        }
    }
}
