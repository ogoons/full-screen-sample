package com.example.fullscreensample

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fullscreensample.databinding.ActivityMainBinding
import com.example.fullscreensample.ui.ContainerFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val navController: NavController by lazy { findNavController(R.id.fcv_container) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}