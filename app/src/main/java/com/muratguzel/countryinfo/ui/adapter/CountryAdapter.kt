package com.muratguzel.countryinfo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.constraintlayout.widget.Placeholder
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muratguzel.countryinfo.data.entity.ChildItem
import com.muratguzel.countryinfo.data.entity.CountryItem
import com.muratguzel.countryinfo.R
import com.muratguzel.countryinfo.databinding.CountryItemBinding
import com.muratguzel.countryinfo.util.imageDownload


class CountryAdapter(private val countryList: ArrayList<CountryItem>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
    inner class CountryViewHolder(val binding: CountryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private fun setChildRecyclerView(childItemList: List<ChildItem>) {
            binding.recyclerCard.visibility = View.VISIBLE
            val adapter = ChildAdapter(childItemList)
            binding.childRecyclerView.adapter = adapter
        }


        private fun isAnyOpened(position: Int) {
            val temp = countryList.indexOfFirst {
                it.Country1.isOpen or it.Country2.isOpen
            }

            if (temp >= 0 && temp != position) {
                countryList[temp].Country1.isOpen = false
                countryList[temp].Country2.isOpen = false
                notifyItemChanged(temp, 12)
            }

        }

        fun closeExpandedViews() {
            binding.recyclerCard.visibility = View.GONE

        }

        init {
            binding.childRecyclerView.setHasFixedSize(true)
            binding.childRecyclerView.layoutManager = LinearLayoutManager(binding.root.context)

            binding.card1.setOnClickListener {
                val upAnim = AnimationUtils.loadAnimation(binding.root.context, R.anim.up)
                val downAnim = AnimationUtils.loadAnimation(binding.root.context, R.anim.down)

                val countryContent = countryList[adapterPosition].Country1
                isAnyOpened(adapterPosition)
                countryContent.isOpen =
                    !countryContent.isOpen

                if (countryContent.isOpen) {
                    binding.card1.startAnimation(downAnim)
                    binding.recyclerCard.startAnimation(downAnim)

                } else {
                    binding.card1.startAnimation(upAnim)
                }

                if (countryList[adapterPosition].Country2.isOpen) {
                    binding.card2.startAnimation(upAnim)
                }
                countryList[adapterPosition].Country2.isOpen = false
                notifyItemChanged(adapterPosition, Unit)
            }


            binding.card2.setOnClickListener {
                val upAnim = AnimationUtils.loadAnimation(binding.root.context, R.anim.up)
                val downAnim = AnimationUtils.loadAnimation(binding.root.context, R.anim.down)

                val countryContent = countryList[adapterPosition].Country2
                isAnyOpened(adapterPosition)
                countryContent.isOpen =
                    !countryContent.isOpen

                if (countryContent.isOpen) {
                    binding.card2.startAnimation(downAnim)
                    binding.recyclerCard.startAnimation(downAnim)
                } else {
                    binding.card2.startAnimation(upAnim)
                }
                if (countryList[adapterPosition].Country1.isOpen) {
                    binding.card1.startAnimation(upAnim)
                }
                countryList[adapterPosition].Country1.isOpen = false
                notifyItemChanged(adapterPosition, Unit)
            }

        }

        fun bind(countryItem: CountryItem) {

            binding.countryTv.text = countryItem.Country1.name
            binding.countryIv.imageDownload(countryItem.Country1.flag)

            binding.country2Tv.text = countryItem.Country2.name
            binding.country2Iv.imageDownload(countryItem.Country2.flag)

            // Elemanın özelliklerini kontrol et
            if (countryItem.Country2.name!!.isEmpty() &&
                countryItem.Country2.capital!!.isEmpty() &&
                countryItem.Country2.region!!.isEmpty() &&
                countryItem.Country2.currency!!.isEmpty() &&
                countryItem.Country2.flag!!.isEmpty() &&
                countryItem.Country2.language!!.isEmpty()
            ) {

                // Elemanın görünürlüğünü GONE olarak ayarla
                binding.card2.visibility = View.GONE
            } else {
                // Elemanın görünürlüğünü VISIBLE olarak ayarla
                binding.card2.visibility = View.VISIBLE

            }

                when (true) {

                    countryItem.Country1.isOpen -> {
                        setChildRecyclerView(countryItem.Country1.childItemList)
                    }

                    countryItem.Country2.isOpen -> {
                        setChildRecyclerView(countryItem.Country2.childItemList)
                    }

                    else -> {
                        binding.recyclerCard.visibility = View.GONE

                    }
                }
            }
        }



    override fun onBindViewHolder(
        holder: CountryViewHolder,
        position: Int,
        payloads: MutableList<Any>,
    ) {
        if (payloads.isNotEmpty() && payloads[0] == 12) {
            holder.closeExpandedViews()

        } else {
            super.onBindViewHolder(holder, position, payloads)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding =
            CountryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }


    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        holder.bind(countryList[position])

    }

    fun updateAdapter(countryNewList : List<CountryItem>){
        countryList.clear()
        countryList.addAll(countryNewList)
        notifyDataSetChanged()
    }
}





