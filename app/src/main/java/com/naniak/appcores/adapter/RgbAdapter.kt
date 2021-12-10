package com.naniak.appcores.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.toColor
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.naniak.appcores.databinding.ItemCardRgbBinding

class RgbAdapter(private val listColor : List<RgbModel?>): RecyclerView.Adapter<RgbAdapter.RgbViewHolder>() {


    class RgbViewHolder(var binding: ItemCardRgbBinding): RecyclerView.ViewHolder(binding.root) {


        @SuppressLint("SetTextI18n")
        fun bind(rgbModel: RgbModel){
            binding.itemCard.setBackgroundColor(rgbModel.resultado)
            binding.colorResult.text = " R: ${rgbModel.rgb?.first} / G:  ${rgbModel.rgb?.second } / B:  ${rgbModel.rgb?.third}"
            binding.colorHex.text = "Hex : ${rgbModel.hex}"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RgbViewHolder {
        ItemCardRgbBinding.inflate(LayoutInflater.from(parent.context),parent,false).let {
           return  RgbViewHolder(it)
        }
    }

    override fun onBindViewHolder(holder: RgbAdapter.RgbViewHolder, position: Int) {
        listColor[position]?.let { holder.bind(it) }
    }

    override fun getItemCount() = listColor.size
}

