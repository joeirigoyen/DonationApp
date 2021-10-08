package com.example.securityintegration.Views.Landing

import android.media.metrics.Event
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
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
import com.example.securityintegration.Views.Profile.MyProjects.ProfileLookupFragment
import com.example.securityintegration.Views.Profile.ProfileFragment
import com.example.securityintegration.Views.Projects.ProjectListFragment
import com.example.securityintegration.Views.Projects.ProjectLookupFragment
import com.example.securityintegration.databinding.ActivityMainPageBinding
import com.paypal.checkout.approve.OnApprove
import com.paypal.checkout.cancel.OnCancel
import com.paypal.checkout.createorder.CreateOrder
import com.paypal.checkout.createorder.CurrencyCode
import com.paypal.checkout.createorder.OrderIntent
import com.paypal.checkout.createorder.UserAction
import com.paypal.checkout.error.OnError
import com.paypal.checkout.order.Amount
import com.paypal.checkout.order.AppContext
import com.paypal.checkout.order.Order
import com.paypal.checkout.order.PurchaseUnit
import com.paypal.checkout.paymentbutton.PayPalButton
import kotlinx.coroutines.selects.select

class MainPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainPageBinding
    internal var selectedFragment: Fragment? = null
    lateinit var navView: BottomNavigationView

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
        // Switch to profile fragment by default
        moveToFragment(ProfileLookupFragment())
        // Set up NavBar events
        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_profile -> {
                    moveToFragment(ProfileLookupFragment())
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