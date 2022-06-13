package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class Adapter: RecyclerView.Adapter<Adapter.MyViewClass>() {


    private val question: List<String> = listOf()
    private val type: List<String> = listOf()
    private val answer: List<String> = listOf()
    private val id: List<String> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.MyViewClass {
        val binding:ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
        R.layout.item, parent,false)
        return MyViewClass(binding)
    }

    override fun onBindViewHolder(holder: Adapter.MyViewClass, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return question.size
    }
    public class MyViewClass(private val binding: ViewDataBinding):RecyclerView.ViewHolder(binding.root){
    }

}