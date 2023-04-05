package com.example.bmi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bmi.R
import com.example.bmi.databinding.ActivityMainQoshimchaMalumotBinding
import com.example.bmi.view.adapters.QoshimchaAdapter
import com.example.bmi.viewModel.AsosiyViewModel

class MainActivityQoshimchaMalumot : AppCompatActivity() {
    lateinit var binding:ActivityMainQoshimchaMalumotBinding
    lateinit var asosiyViewModel: AsosiyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainQoshimchaMalumotBinding.inflate(layoutInflater)
        setContentView(binding.root)
        asosiyViewModel = ViewModelProvider(this).get(AsosiyViewModel::class.java)


        binding.apply {
            textTitle.text = intent.getStringExtra("title")
            if (intent.getIntExtra("name", 0) == 1){
                textMalumot.text = asosiyViewModel.malumot
            }else{
                textMalumot.text = intent.getStringExtra("malumot")
            }



            toolbarBack.setOnClickListener {
                finish()
            }
        }
    }
}