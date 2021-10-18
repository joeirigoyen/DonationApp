package com.example.securityintegration.Views.Landing

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.ui.AppBarConfiguration
import com.example.securityintegration.R
import com.example.securityintegration.Views.Events.EventLookupFragment
import com.example.securityintegration.Views.OrgLookup.OrgLookupFragment
import com.example.securityintegration.Views.Profile.MyProjects.ProfileLookupFragment
import com.example.securityintegration.Views.Projects.ProjectLookupFragment
import com.example.securityintegration.databinding.ActivityMainPageBinding
import kotlin.properties.Delegates

class MainPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainPageBinding
    internal var selectedFragment: Fragment? = null
    lateinit var navView: BottomNavigationView
    lateinit var accUsername : String
    lateinit var accNames :  String
    var accType by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set bindings
        binding = ActivityMainPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Set view variables
        navView = binding.navView
        // Passing each menu ID as a set of Ids because each menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_profile,
                R.id.navigation_orgs,
                R.id.navigation_events,
                R.id.navigation_projects
            )
        )
        // Get args
        accUsername = intent.getStringExtra("username").toString()
        accNames = intent.getStringExtra("names").toString()
        accType = intent.getIntExtra("accType", 0)
        // Switch to profile fragment by default
        moveToFragment(ProfileLookupFragment(), accUsername)
        // Set up NavBar events
        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_profile -> {
                    moveToFragment(ProfileLookupFragment(), accUsername)
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_orgs -> {
                    moveToFragment(OrgLookupFragment(), accUsername)
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_events -> {
                    moveToFragment(EventLookupFragment(), accUsername)
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_projects -> {
                    moveToFragment(ProjectLookupFragment(), accUsername)
                    return@setOnItemSelectedListener true
                }
                else -> {
                    return@setOnItemSelectedListener false
                }
            }
        }
    }

    private fun moveToFragment(frag: Fragment, username: String) {
        val bundle = Bundle()
        bundle.putString("username", username)
        frag.arguments = bundle
        val fragTrans = supportFragmentManager.beginTransaction()
        fragTrans.replace(R.id.main_frag_container, frag).commit()
    }

}