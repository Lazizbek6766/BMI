package com.example.bmi.view

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.GravityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bmi.R
import com.example.bmi.databinding.ActivityMainBinding
import com.example.bmi.model.AsosiyModel
import com.example.bmi.model.repositori.Repositori
import com.example.bmi.view.adapters.AsosiyAdapter
import com.example.bmi.viewModel.AsosiyViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var asosiyAdapter: AsosiyAdapter
    lateinit var asosiyViewModel:AsosiyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(binding.root)

        asosiyViewModel = ViewModelProvider(this).get(AsosiyViewModel::class.java)


        binding.apply {
            toolbarMenu.setOnClickListener {
                drawerLayout.openDrawer(GravityCompat.START)
            }

            recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
            asosiyAdapter = AsosiyAdapter(this@MainActivity, asosiyViewModel.arrayListAsosiy)
            recyclerView.adapter = asosiyAdapter

        }





        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_item_1 -> {
                    // Home sahifasiga o'tish
                    true
                }
                R.id.nav_item_2 -> {
                    // Profil sahifasiga o'tish
                    true
                }
                R.id.nav_item_3 -> {
                    finish()
                    true
                }
                else -> false
            }
        }
    }
}