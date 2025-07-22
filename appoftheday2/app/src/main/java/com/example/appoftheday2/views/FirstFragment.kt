package com.example.appoftheday2.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.runtime.snapshots.Snapshot.Companion.observe
import androidx.compose.ui.state.ToggleableState
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.appoftheday2.R
import com.example.appoftheday2.databinding.FragmentFirstBinding
import com.example.appoftheday2.viewmodel.CountViewModel
import kotlin.math.absoluteValue
import kotlin.properties.ReadOnlyProperty

/**
 * A simple [androidx.fragment.app.Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    private val countViewModel:  CountViewModel by activityViewModels()
//    private val countViewModel: CountViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        countViewModel.getMutableLiveData().observe(viewLifecycleOwner, Observer { incomingValue ->
            Log.i("Harry", "Received Value: " + incomingValue)
            Toast.makeText(view.context, "received: " + incomingValue, Toast.LENGTH_SHORT).show()
            binding.textviewFirst.text = "Count:  " + incomingValue
        })

        countViewModel.getMutableLiveData().observe(viewLifecycleOwner, Observer{ set ->
            Log.i("harry", "Received value " + set)
            Toast.makeText(view.context, "received value " + set, Toast.LENGTH_SHORT).show()
            binding.textviewFirst.text = "count: " + set
        })

        binding.incrementButtom.setOnClickListener {
            countViewModel.increment()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


