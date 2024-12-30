package com.muratguzel.countryinfo.ui.view

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.muratguzel.countryinfo.data.entity.ChildItem
import com.muratguzel.countryinfo.data.entity.Country
import com.muratguzel.countryinfo.data.entity.CountryItem
import com.muratguzel.countryinfo.R
import com.muratguzel.countryinfo.databinding.ActivityMainBinding
import com.muratguzel.countryinfo.ui.adapter.CountryAdapter
import com.muratguzel.countryinfo.ui.viewModel.CountryViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val countryViewModel: CountryViewModel by viewModels<CountryViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        countryViewModel.refreshData(this)

        binding.mainRecyclerView.setHasFixedSize(true)
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this.applicationContext)

        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.mainRecyclerView.visibility = View.GONE
            binding.countrLoading.visibility = View.VISIBLE
            countryViewModel.getDataFromInternet(this)
            binding.swipeRefreshLayout.isRefreshing = false
        }

        observeLiveData()
    }

    private fun observeLiveData() {

        countryViewModel.countryList.observe(this) { countryItemList ->
            countryItemList?.let {
                var adapter = CountryAdapter(arrayListOf(),binding.mainRecyclerView)

                adapter.updateAdapter(countryItemList)
                binding.mainRecyclerView.adapter = adapter
                binding.mainRecyclerView.visibility = View.VISIBLE
                binding.countrLoading.visibility = View.GONE
            }
        }

    }
}