package com.muratguzel.countryinfo.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.muratguzel.countryinfo.data.entity.ChildItem
import com.muratguzel.countryinfo.data.entity.Country
import com.muratguzel.countryinfo.data.entity.CountryItem
import com.muratguzel.countryinfo.R
import com.muratguzel.countryinfo.databinding.ActivityMainBinding
import com.muratguzel.countryinfo.ui.adapter.CountryAdapter

class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.mainRecyclerView.setHasFixedSize(true)
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)

        prepareData()
    }
    private fun prepareData(){

        val parentItemList = mutableListOf<CountryItem>()

        //first item
        val childItems1 = mutableListOf<ChildItem>()
        childItems1.add(ChildItem("Andorra", R.drawable.and))
        childItems1.add(ChildItem("Andorra Vella" , R.drawable.and))
        childItems1.add(ChildItem("Europe" , R.drawable.and))
        childItems1.add(ChildItem("Catalan" , R.drawable.and))
        val country1 = Country("Andorra","Andorra la Vella","Europe","EUR","and","Catalan",childItems1)

        val childItems2 = mutableListOf<ChildItem>()
        childItems2.add(ChildItem("nbcvncn", R.drawable.and))
        childItems2.add(ChildItem("Andorra Vella" , R.drawable.and))
        childItems2.add(ChildItem("Europe" , R.drawable.and))
        childItems2.add(ChildItem("Catalan" , R.drawable.and))
        val country2 = Country("Andorra","Andorra la Vella","Europe","EUR","and","Catalan",childItems2)

        parentItemList.add(CountryItem(country1 , country2))
        val adapter = CountryAdapter(parentItemList)
        binding.mainRecyclerView.adapter = adapter

    }
}