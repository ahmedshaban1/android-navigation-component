package com.example.navigationcomponentsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.navigationcomponentsexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigation.itemIconTintList = null
        init()
    }

    private fun init() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        setupWithNavController(binding.bottomNavigation,navController)


        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.callLogsFragment, R.id.contactsFragment,R.id.profileFragment -> {
                    binding.bottomNavigation.isVisible = true
                }
                else -> {
                    binding.bottomNavigation.isVisible = false
               }
            }
       }
    }
}