package com.example.securityintegration.Views.Landing

import android.media.metrics.Event
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.securityintegration.R
import com.example.securityintegration.Views.Events.EventListFragment
import com.example.securityintegration.Views.Events.EventLookupFragment
import com.example.securityintegration.Views.Landing.MainPageActivity
import com.example.securityintegration.Views.OrgLookup.OrgListFragment
import com.example.securityintegration.Views.OrgLookup.OrgLookupFragment
import com.example.securityintegration.Views.Profile.ProfileFragment
import com.example.securityintegration.Views.Projects.ProjectListFragment
import com.example.securityintegration.Views.Projects.ProjectLookupFragment
import com.example.securityintegration.databinding.ActivityMainPageBinding
import kotlinx.coroutines.selects.select

class MainPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainPageBinding
    internal var selectedFragment: Fragment? = null
    lateinit var navView: BottomNavigationView
    lateinit var navHostFragment: NavHostFragment
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set bindings
        binding = ActivityMainPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Set view variables
        navView = binding.navView
        navHostFragment = supportFragmentManager.findFragmentById(R.id.main_frag_container) as NavHostFragment
        navController = navHostFragment.navController

        // Passing each menu ID as a set of Ids because each menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_profile,
                R.id.navigation_orgs,
                R.id.navigation_events,
                R.id.navigation_projects
            )
        )
        // Switch to profile fragment by default
        moveToFragment(ProfileFragment())
        // Set up NavBar events
        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_profile -> {
                    moveToFragment(ProfileFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_orgs -> {
                    moveToFragment(OrgLookupFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_events -> {
                    moveToFragment(EventLookupFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_projects -> {
                    moveToFragment(ProjectLookupFragment())
                    return@setOnItemSelectedListener true
                }
                else -> {
                    return@setOnItemSelectedListener false
                }
            }
        }
    }

    private fun moveToFragment(frag: Fragment) {
        val fragTrans = supportFragmentManager.beginTransaction()
        fragTrans.replace(R.id.main_frag_container, frag).commit()
    }

}