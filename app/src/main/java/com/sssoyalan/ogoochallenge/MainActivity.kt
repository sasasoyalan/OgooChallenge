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

        rcyBadgeAdapter = RcyBadgeAdapter(mutableListOf(), BadgesCount(Badge3(0,0,0f),Badge4(0,0,0f),Badge5(0,0,0f),
            Badge6(0,0,0f),Badge7(0,0,0f), Badge8(0,0,0f),
                Badge9(0,0,0f),Badge10(0,0,0f),Badge11(0,0,0f)))
        binding.recyc2.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        var totalRating : Float = 0f
        var totalItem : Int
        val badgesCount = BadgesCount()
        val badgesAndValues = BadgesAndValues()
        val valuesListtop: MutableList<MutableList<Value>> = mutableListOf<MutableList<Value>>()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.alLiveData.observe(this){
              totalItem= it.rows!!.size
            for (i in 0 until it.rows.size-1) {
                totalRating += it.rows[i].PraiseRating.toFloat()
                val id = it.rows[i].Badge[0].lookupId
                val value_ : Int = it.rows[i].PraiseRating.toInt()
                when (id) {
                    3 -> {
                        badgesCount.badge3.let { badge3 -> badge3.count+=1  }
                        badgesCount.badge3.let { badge3 -> badge3.total+=value_ }
                    }
                    4 -> {
                        badgesCount.badge4.let { badge4 -> badge4.count+=1  }
                        badgesCount.badge4.let { badge4 -> badge4.total+=value_ }
                    }
                    5 -> {
                        badgesCount.badge5.let { badge5 -> badge5.count+=1  }
                        badgesCount.badge5.let { badge5 -> badge5.total+=value_ }
                    }
                    6 -> {
                        badgesCount.badge6.let { badge6 -> badge6.count+=1  }
                        badgesCount.badge6.let { badge6 -> badge6.total+=value_ }
                    }
                    7 -> {badgesCount.badge7?. let { badge7 -> badge7.count+=1  }
                        badgesCount.badge7?. let { badge7 -> badge7.total+=value_ }}
                    8 -> {badgesCount.badge8?. let { badge8 -> badge8.count+=1  }
                        badgesCount.badge8?. let { badge8 -> badge8.total+=value_ }}
                    9 -> {badgesCount.badge9?. let { badge9 -> badge9.count+=1  }
                        badgesCount.badge9?. let { badge9 -> badge9.total+=value_ }}
                    10 -> {badgesCount.badge10?. let { badge10 -> badge10.count+=1  }
                        badgesCount.badge10?. let { badge10 -> badge10.total+=value_ }}
                    11 -> {badgesCount.badge11?. let { badge11 -> badge11.count+=1  }
                        badgesCount.badge11?. let { badge11 -> badge11.total+=value_ }}
                }
            }
            badgesCount.badge3.let { badge3 -> badge3.avarage=(badgesCount.badge3.total/ badgesCount.badge3.count).toFloat()}
            badgesCount.badge4.let { badge4 -> badge4.avarage=(badgesCount.badge4.total/ badgesCount.badge4.count).toFloat()}
            badgesCount.badge5.let { badge5 -> badge5.avarage=(badgesCount.badge5.total/ badgesCount.badge5.count).toFloat()}
            badgesCount.badge6.let { badge6 -> badge6.avarage=(badgesCount.badge6.total/ badgesCount.badge6.count).toFloat()}
            badgesCount.badge7.let { badge7 -> badge7.avarage=(badgesCount.badge7.total/ badgesCount.badge7.count).toFloat()}
            badgesCount.badge8.let { badge8 -> badge8.avarage=(badgesCount.badge8.total/ badgesCount.badge8.count).toFloat()}
            badgesCount.badge9.let { badge9 -> badge9.avarage=(badgesCount.badge9.total/ badgesCount.badge9.count).toFloat()}
            badgesCount.badge10.let { badge10 -> badge10.avarage=(badgesCount.badge10.total/ badgesCount.badge10.count).toFloat()}
            badgesCount.badge11.let { badge11 -> badge11.avarage=(badgesCount.badge11.total/ badgesCount.badge11.count).toFloat()}

            binding.mainBadgeCount.text=it.rows.size.toString()+" Adet"

            binding.mainRatingbar.rating=totalRating/it.rows.size
            binding.mainRatingText.text=(totalRating/it.rows.size).toString().trim().substring(0,3)
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
                badgesAndValues,
                badgesCount,
                rcyBadgeAdapter
            )
            binding.wormDotsIndicator.setViewPager2(binding.viewpager2)
        }
        viewModel.fetchAll(this@MainActivity)

    }
}