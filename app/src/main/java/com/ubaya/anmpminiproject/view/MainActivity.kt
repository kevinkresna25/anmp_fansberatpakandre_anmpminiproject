package com.ubaya.anmpminiproject.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.ubaya.anmpminiproject.R
import com.ubaya.anmpminiproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        drawerLayout = binding.drawerLayout
        navController = (supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment).navController

        // menghubungkan - NavController dengan ActionBar
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        // menghubungkan - setup drawer
        binding.bottomNav.setupWithNavController(navController)

        // menghubungkan - bottom bar
        binding.navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, drawerLayout) || super.onSupportNavigateUp()
    }
}