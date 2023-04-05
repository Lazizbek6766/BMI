package com.example.bmi.view.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.bmi.databinding.RecaclerViewItemBinding
import com.example.bmi.databinding.RecyclerViewQoshimchaItemBinding
import com.example.bmi.model.AsosiyModel
import com.example.bmi.model.QoshimchaModel
import com.example.bmi.view.MainActivityQoshimcha
import com.example.bmi.view.MainActivityQoshimchaMalumot

class QoshimchaAdapter(
    val context:Context,
    val arrayList: ArrayList<QoshimchaModel>
):RecyclerView.Adapter<QoshimchaAdapter.AsosiyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsosiyViewHolder {
        val view = RecyclerViewQoshimchaItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return AsosiyViewHolder(view)
    }

    override fun getItemCount(): Int =arrayList.size

    override fun onBindViewHolder(holder: AsosiyViewHolder, position: Int) {
        holder.binding.apply {
            imageQoshimcha.setImageResource(arrayList[position].rasm)
            textQoshimcha.text = arrayList.get(position).text


            btnQoshimcha.setOnClickListener {
                val intent = Intent(context, MainActivityQoshimchaMalumot::class.java)
                intent.putExtra("title", arrayList.get(position).text)
                intent.putExtra("malumot", arrayList.get(position).malumot)
                context.startActivity(intent)
            }


        }
    }

    class AsosiyViewHolder(var binding: RecyclerViewQoshimchaItemBinding):RecyclerView.ViewHolder(binding.root)
}