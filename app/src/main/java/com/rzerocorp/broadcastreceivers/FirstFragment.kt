package com.rzerocorp.broadcastreceivers

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.rzerocorp.broadcastreceivers.databinding.FragmentFirstBinding
import com.rzerocorp.broadcastreceivers.viewmodels.ConnectionLiveData
import com.rzerocorp.broadcastreceivers.viewmodels.PowerCheckLiveData

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private lateinit var powerCheckLiveData: PowerCheckLiveData
    private lateinit var connectionLiveData: ConnectionLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        powerCheckLiveData = PowerCheckLiveData(requireContext())
        connectionLiveData = ConnectionLiveData(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        powerCheckLiveData.observe(viewLifecycleOwner) {
            binding.textviewFirst.text = "My battery level is $it"
        }

        connectionLiveData.observe(viewLifecycleOwner) {
            when(it) {
                false -> binding.textviewSecond.text = "Hey! Give me some Internet, please !!!!"
                true -> binding.textviewSecond.text = "I have Internet!"
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}