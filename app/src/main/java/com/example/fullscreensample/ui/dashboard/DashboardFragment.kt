package com.example.fullscreensample.ui.dashboard

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fullscreensample.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var count = 0

    companion object {

        private const val ARG_COUNT = "count"
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(ARG_COUNT)
        }
        binding.textDashboard.text = count.toString()

        binding.btnIncrease.setOnClickListener {
            ++count
            textView.text = count.toString() // Save to bundle

            val items = (binding.rvCounts.adapter as? CountsAdapter)?.items
            items?.add(count)
            binding.rvCounts.adapter?.notifyDataSetChanged()
        }

        binding.rvCounts.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCounts.adapter = CountsAdapter(dashboardViewModel.items)

        return root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(ARG_COUNT, count)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}