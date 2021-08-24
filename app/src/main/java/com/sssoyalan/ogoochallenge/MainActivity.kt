package com.sssoyalan.ogoochallenge

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.sssoyalan.ogoochallenge.adapters.RcyBadgeAdapter
import com.sssoyalan.ogoochallenge.adapters.RcyUserAdapter
import com.sssoyalan.ogoochallenge.adapters.ViewPagerAdapter
import com.sssoyalan.ogoochallenge.databinding.ActivityMainBinding
import com.sssoyalan.ogoochallenge.models.*
import com.sssoyalan.ogoochallenge.vm.MainViewModel

class MainActivity : AppCompatActivity() {
    //ViewBinding
    private lateinit var binding: ActivityMainBinding
    //ViewModel
    private lateinit var viewModel: MainViewModel
    //Adapter
    lateinit var rcyBadgeAdapter: RcyBadgeAdapter

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val badgesList: MutableList<BadgeModel> = mutableListOf()
        rcyBadgeAdapter = RcyBadgeAdapter(mutableListOf(), badgesList, this@MainActivity)
        binding.recyc2.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        val valuesListtop: MutableList<MutableList<Value>> = mutableListOf<MutableList<Value>>()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.alLiveData.observe(this){

            binding.mainBadgeCount.text=it.rows.size.toString()+" Adet"
            binding.mainRatingbar.rating=it.totalRating/it.rows.size
            binding.mainRatingText.text=(it.totalRating/it.rows.size).toString().trim().substring(0,3)
            binding.recyc2.adapter = RcyUserAdapter(it.rows)

            val bolum: Int=it.badgesCountValue.size/4
            val kalan: Int=it.badgesCountValue.size%4
            for (x in 0 until bolum){
                val valuesList: MutableList<Value> = mutableListOf<Value>()
                for (i in 0..3){
                    valuesList.add(it.badgesCountValue[i+x*4])
                }
                valuesListtop.add(valuesList)
            }
            val valuesList2: MutableList<Value> = mutableListOf<Value>()
            if (kalan==1){
                valuesList2.add(it.badgesCountValue[+4*bolum])
            }else{
                for (x in 0 until kalan){
                    valuesList2.add(it.badgesCountValue[(x-1)+4*bolum])
                }
            }
            valuesListtop.add(valuesList2)

            binding.viewpager2.adapter = ViewPagerAdapter(
                this@MainActivity,
                valuesListtop,
                it.badgesList,
                rcyBadgeAdapter
            )
            binding.wormDotsIndicator.setViewPager2(binding.viewpager2)
        }
        viewModel.fetchAll(this@MainActivity)
    }
}