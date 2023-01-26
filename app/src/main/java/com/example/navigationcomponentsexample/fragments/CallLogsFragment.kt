package com.example.navigationcomponentsexample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponentsexample.R
import com.example.navigationcomponentsexample.databinding.FragmentCallLogsBinding

class CallLogsFragment : Fragment() {

    private var _binding: FragmentCallLogsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCallLogsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.search.setOnClickListener {
            val query = binding.searchEt.text.toString()
            if (query.isNotBlank()) {
                findNavController().navigate(
                    CallLogsFragmentDirections.actionCallLogsFragmentToDetailsFragment(
                        SearchModel(query)
                    )
                )
            }
        }


        binding.openBottomSheet.setOnClickListener {
            findNavController().navigate(CallLogsFragmentDirections.actionCallLogsFragmentToExampleBottomSheet())
        }
    }
}