package com.example.appoftheday2.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.appoftheday2.R
import com.example.appoftheday2.databinding.FragmentSecondBinding
import com.example.appoftheday2.viewmodel.CountViewModel
import kotlin.getValue

/**
 * A simple [androidx.fragment.app.Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val countViewModel:  CountViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        binding.decrementButtom.setOnClickListener {
            countViewModel.decrement()
        }

        countViewModel.getMutableLiveData().observe(viewLifecycleOwner, Observer { incomingValue ->
            Log.i("Harry", "Received Value: " + incomingValue)
            Toast.makeText(view.context, "received: " + incomingValue, Toast.LENGTH_SHORT).show()
            binding.textviewSecond.text = "Count:  " + incomingValue
        })

        countViewModel.getMutableLiveData().observe(viewLifecycleOwner, Observer{ set ->
            Log.i("harry", "Received value " + set)
            Toast.makeText(view.context, "received value " + set, Toast.LENGTH_SHORT).show()
            binding.textviewSecond.text = "count: " + set
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}