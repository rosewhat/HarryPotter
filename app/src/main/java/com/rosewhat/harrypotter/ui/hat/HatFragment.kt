package com.rosewhat.harrypotter.ui.hat

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rosewhat.harrypotter.R
import com.rosewhat.harrypotter.databinding.FragmentHatBinding


class HatFragment : Fragment() {

    private lateinit var hatViewModel: HatViewModel


    private var _binding: FragmentHatBinding? = null
    private val binding: FragmentHatBinding
        get() = _binding ?: throw RuntimeException("FragmentHatBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        hatViewModel = ViewModelProvider(this)[HatViewModel::class.java]
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.edTextWelcome.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(
                editText: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                hatViewModel.applyUserName(name = editText.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        binding.btnWelcomeSelect.setOnClickListener {
            if (binding.btnWelcomeSelect.text == getString(R.string.welcome_next)) {
                // move to another fragment
            } else {
                hatViewModel.getFacultyName()
            }

        }
        hatViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            binding.edTextWelcome.isEnabled = !it
            binding.btnWelcomeSelect.isEnabled = !it
            if (it) {
                binding.btnWelcomeSelect.text = getString(R.string.welcome_selecting)
            }

        })
        hatViewModel.facultyName.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()) {
                binding.tvWelcomeSelected.text =
                    getString(R.string.welcome_selected).replace("[faculty_name]", it)
                binding.tvWelcomeSelected.visibility = View.VISIBLE
                binding.btnWelcomeSelect.text = getString(R.string.welcome_next)
            } else {
                binding.tvWelcomeSelected.visibility = View.GONE
            }
        })
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