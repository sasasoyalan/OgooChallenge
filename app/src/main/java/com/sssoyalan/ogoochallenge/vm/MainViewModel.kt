package com.sssoyalan.ogoochallenge.vm

import Rows
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sssoyalan.ogoochallenge.models.*
import com.sssoyalan.ogoochallenge.source.DataRepository
import com.sssoyalan.ogoochallenge.source.ParsingImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.internal.immutableListOf

class MainViewModel : ViewModel() {

    private val dataRepository = DataRepository(ParsingImpl())

    val alLiveData = MutableLiveData<All>()

    fun fetchAll(context: Context) {
        viewModelScope.launch {
            val all : All = withContext(Dispatchers.IO){
                dataRepository.getAll(context)
            }

            val badgesList: MutableList<BadgeModel> = mutableListOf()
            var totalRating : Float = 0f

            /*   Burada oluşturulan badgemodel listesi , elimizde id başlangıç değeri 3 olduğu için
               for döngüsü 3 ten başlatıldı.  */
            for (i in 3 until all.badgesCountValue.size){
                val badges = BadgeModel(0,0,0f,i)
                badgesList.add(badges)
            }

            for (i in 0 until all.rows.size-1) {
                totalRating += all.rows[i].PraiseRating.toFloat()
                val id = all.rows[i].Badge[0].lookupId
                val value : Int = all.rows[i].PraiseRating.toInt()

                for (j in 0 until badgesList.size-1){
                    if (badgesList.get(j).id==id){
                        badgesList.get(j).count+=1
                        badgesList.get(j).total+=value
                        break
                    }
                }
            }

            for(i in 0 until badgesList.size-1){
                badgesList.get(i).avarage=(badgesList.get(i).total/badgesList.get(i).count).toFloat()
            }

            all.badgesList=badgesList
            all.totalRating=totalRating
            alLiveData.value=all
        }
    }
}