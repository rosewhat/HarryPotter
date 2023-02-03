package com.rosewhat.harrypotter.ui.hat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rosewhat.harrypotter.databinding.FragmentHatBinding


class HatFragment : Fragment() {

    private lateinit var viewModel: HatViewModel


    private var _binding: FragmentHatBinding? = null
    private val binding: FragmentHatBinding
        get() = _binding ?: throw RuntimeException("FragmentHatBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this)[HatViewModel::class.java]
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHatBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}