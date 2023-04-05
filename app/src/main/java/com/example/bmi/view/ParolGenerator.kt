package com.example.bmi.view

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import androidx.lifecycle.ViewModelProvider
import com.example.bmi.PAROLGENERATOR
import com.example.bmi.R
import com.example.bmi.databinding.ActivityParolGeneratorBinding
import com.example.bmi.viewModel.AsosiyViewModel

class ParolGenerator : AppCompatActivity() {
    lateinit var binding: ActivityParolGeneratorBinding
    var parol: String? = null
    lateinit var asosiyViewModel: AsosiyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParolGeneratorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        PAROLGENERATOR = this
        asosiyViewModel = ViewModelProvider(this@ParolGenerator).get(AsosiyViewModel::class.java)
        load()
        binding.apply {
            textTitle.text = intent.getStringExtra("title")
            textGenerator.text = parol


            textCopy.setOnClickListener {
                val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip = ClipData.newPlainText("label", textGenerator.text)
                clipboard.setPrimaryClip(clip)
            }

            btnGenerator.setOnClickListener {
                val length = lengthSeekBar.progress
                asosiyViewModel.newgeneratePassword(
                    length,
                    2
                ) //2 sonini orniga biror son qo'yish usulini qidirish...
                load()
                textGenerator.text = parol
            }

            lengthSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    binding.lengthLabel.text = "Length: $progress"
                }
                override fun onStartTrackingTouch(seekBar: SeekBar?) {}

                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            })

            toolbarBack.setOnClickListener {
                finish()
            }
        }


    }


    fun save(text: String?) {
        val editor = getSharedPreferences("Parol", MODE_PRIVATE).edit() as SharedPreferences.Editor
        editor.putString("parol", text)
        editor.commit()
    }

    fun load() {
        val sharedPreferences = getSharedPreferences("Parol", MODE_PRIVATE)
        parol = sharedPreferences.getString("parol", null)
    }
}