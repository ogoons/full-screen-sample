package com.example.fullscreensample.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fullscreensample.R
import com.example.fullscreensample.databinding.FragmentContainerBinding
import com.example.fullscreensample.databinding.FragmentHomeBinding
import com.example.fullscreensample.ui.dashboard.DashboardFragment
import com.example.fullscreensample.ui.home.HomeFragment
import com.example.fullscreensample.ui.home.HomeViewModel
import com.example.fullscreensample.ui.notifications.NotificationsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ContainerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ContainerFragment : Fragment() {

    private var _binding: FragmentContainerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContainerBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navView: BottomNavigationView = binding.navView

        navView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    childFragmentManager.commit {
                        replace(R.id.fcv_container, HomeFragment())
                    }
                }
                R.id.navigation_dashboard -> {
                    childFragmentManager.commit {
                        replace(R.id.fcv_container, DashboardFragment())
                    }
                }
                R.id.navigation_notifications -> {
                    childFragmentManager.commit {
                        replace(R.id.fcv_container, NotificationsFragment())
                    }
                }
                else -> {

                }
            }
            true
        }

        childFragmentManager.commit {
            replace(R.id.fcv_container, HomeFragment())
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ContainerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ContainerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}