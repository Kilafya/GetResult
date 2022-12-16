package com.android.getresult.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.android.getresult.R
import com.android.getresult.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding: FragmentSecondBinding get() = _binding!!

    private var textValue = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
        parsParam()
        setupText()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setClickListener() {
        binding.btnSave.setOnClickListener {
            parentFragmentManager.setFragmentResult(
                FirstFragment.REQUEST_KEY, bundleOf(
                    FirstFragment.VALUE_KEY to binding.etValue.text.toString()
                )
            )
            activity?.onBackPressed()
        }
    }

    private fun setupText() {
        binding.etValue.setText(textValue)
    }

    private fun parsParam() {
        textValue = arguments?.getString(VALUE_KEY) ?: ""
    }

    companion object {
        private const val VALUE_KEY = "extra_value"

        fun newInstance(value: String?) = SecondFragment().apply {
            arguments = Bundle().apply {
                putString(VALUE_KEY, value)
            }
        }
    }
}