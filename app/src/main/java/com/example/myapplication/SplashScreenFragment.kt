package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentSplashScreenBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashScreenFragment : Fragment() {

    private lateinit var binding: FragmentSplashScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentSplashScreenBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val img = AnimationUtils.loadAnimation(requireContext(), R.anim.animation)
        binding.imgSplashScreen.startAnimation(img)

        lifecycleScope.launch{
            delay(5000)
            findNavController().navigate(R.id.action_splash_screen_Fragment_to_FirstFragment)
        }

    }
}