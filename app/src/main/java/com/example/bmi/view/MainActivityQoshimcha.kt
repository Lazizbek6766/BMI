package com.example.bmi.view

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bmi.R
import com.example.bmi.databinding.ActivityMainQoshimchaBinding
import com.example.bmi.model.QoshimchaModel
import com.example.bmi.view.adapters.AsosiyAdapter
import com.example.bmi.view.adapters.QoshimchaAdapter
import com.example.bmi.viewModel.AsosiyViewModel

class MainActivityQoshimcha : AppCompatActivity() {
    lateinit var binding:ActivityMainQoshimchaBinding
    lateinit var qoshimchaAdapter:QoshimchaAdapter
    lateinit var asosiyViewModel:AsosiyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainQoshimchaBinding.inflate(layoutInflater)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(binding.root)
        asosiyViewModel = ViewModelProvider(this).get(AsosiyViewModel::class.java)

        val a = intent.getIntExtra("name", 0)




        binding.apply {
            textTitle.text = intent.getStringExtra("title")

            if (a == 0){
                recyclerViewQoshimcha.layoutManager = LinearLayoutManager(this@MainActivityQoshimcha)
                qoshimchaAdapter = QoshimchaAdapter(this@MainActivityQoshimcha, asosiyViewModel.arraytushuncha)
                recyclerViewQoshimcha.adapter = qoshimchaAdapter
            }
            if (a == 1){
                recyclerViewQoshimcha.layoutManager = LinearLayoutManager(this@MainActivityQoshimcha)
                qoshimchaAdapter = QoshimchaAdapter(this@MainActivityQoshimcha, asosiyViewModel.arrayqoida)
                recyclerViewQoshimcha.adapter = qoshimchaAdapter
            }
            if (a == 2){
                recyclerViewQoshimcha.layoutManager = LinearLayoutManager(this@MainActivityQoshimcha)
                qoshimchaAdapter = QoshimchaAdapter(this@MainActivityQoshimcha, asosiyViewModel.arraymalumot)
                recyclerViewQoshimcha.adapter = qoshimchaAdapter
            }

            toolbarBack.setOnClickListener {
                finish()
            }
        }
    }
}