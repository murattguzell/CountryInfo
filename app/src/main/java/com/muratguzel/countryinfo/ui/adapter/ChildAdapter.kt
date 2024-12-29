package com.muratguzel.countryinfo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muratguzel.countryinfo.data.entity.ChildItem
import com.muratguzel.countryinfo.databinding.ChildItemBinding

class ChildAdapter(private val childItemList: List<ChildItem>) :
    RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {

    inner class ChildViewHolder( val binding: ChildItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val binding = ChildItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChildViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        holder.binding.childLogoIv.setImageResource(childItemList[position].flag!!)
        holder.binding.childTitleTv.text = childItemList[position].name
    }

    override fun getItemCount(): Int {
        return childItemList.size
    }
}
