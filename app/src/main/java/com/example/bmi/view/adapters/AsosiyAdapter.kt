package com.example.bmi.view.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView
import com.example.bmi.databinding.RecaclerViewItemBinding
import com.example.bmi.model.AsosiyModel
import com.example.bmi.view.MainActivityQoshimcha
import com.example.bmi.view.MainActivityQoshimchaMalumot
import com.example.bmi.view.MainActivityTest
import com.example.bmi.view.ParolGenerator

class AsosiyAdapter(
    val context:Context,
    val arrayList: ArrayList<AsosiyModel>
):RecyclerView.Adapter<AsosiyAdapter.AsosiyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsosiyViewHolder {
        val view = RecaclerViewItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return AsosiyViewHolder(view)
    }

    override fun getItemCount(): Int =arrayList.size

    override fun onBindViewHolder(holder: AsosiyViewHolder, position: Int) {
        holder.binding.apply {
            image.setImageResource(arrayList[position].image)
            nameText.text = arrayList.get(position).text1
            nameText2.text = arrayList.get(position).text2

            btnAsosiy.setOnClickListener {
                when(position){
                    0->{
                        val intent = Intent(context, MainActivityQoshimcha::class.java)
                        intent.putExtra("name",0)
                        intent.putExtra("title", arrayList.get(position).text1)
                        context.startActivity(intent)
                    }
                    1->{
                        val intent = Intent(context, MainActivityQoshimcha::class.java)
                        intent.putExtra("name",1)
                        intent.putExtra("title", arrayList.get(position).text1)
                        context.startActivity(intent)
                    }
                    2->{
                        val intent = Intent(context, MainActivityQoshimcha::class.java)
                        intent.putExtra("name",2)
                        intent.putExtra("title", arrayList.get(position).text1)
                        context.startActivity(intent)
                    }
                    3->{
                        val intent = Intent(context, MainActivityQoshimchaMalumot::class.java)
                        intent.putExtra("name",1)
                        intent.putExtra("title", arrayList.get(position).text1)
                        context.startActivity(intent)
                    }
                    4->{
                        val intent = Intent(context, MainActivityTest::class.java)
                        intent.putExtra("title", arrayList.get(position).text1)
                        context.startActivity(intent)
                    }
                    5->{
                        val intent = Intent(context, ParolGenerator::class.java)
                        intent.putExtra("title", arrayList.get(position).text1)
                        context.startActivity(intent)
                    }
                }
            }
        }
    }


    class AsosiyViewHolder(var binding: RecaclerViewItemBinding):RecyclerView.ViewHolder(binding.root)
}