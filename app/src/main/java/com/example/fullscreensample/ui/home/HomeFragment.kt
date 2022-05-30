package com.example.fullscreensample.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fullscreensample.MainActivity
import com.example.fullscreensample.R
import com.example.fullscreensample.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.btnGoToFull.setOnClickListener {
//            (requireActivity() as MainActivity).supportFragmentManager.commit {
//                add(R.id.fcv_container, FullFragment())
//                addToBackStack(null)
//            }
//        }

        binding.btnGoToFull.setOnClickListener {
            (requireActivity() as MainActivity).navController.navigate(R.id.navigation_full_first)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}