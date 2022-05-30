package com.example.fullscreensample.ui.home.full

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.fullscreensample.MainActivity
import com.example.fullscreensample.R


class FullFirstFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_full_first, container, false)
        view.setOnTouchListener { _, _ ->
            true
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.btn_go_to_full_second)
        button.setOnClickListener {
            (requireActivity() as MainActivity).navController.navigate(R.id.navigation_full_second)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}