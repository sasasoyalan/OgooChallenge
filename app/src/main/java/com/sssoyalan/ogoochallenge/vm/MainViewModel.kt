package com.sssoyalan.ogoochallenge.vm

import Rows
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sssoyalan.ogoochallenge.models.All
import com.sssoyalan.ogoochallenge.models.Badges
import com.sssoyalan.ogoochallenge.source.DataRepository
import com.sssoyalan.ogoochallenge.source.ParsingImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    private val dataRepository = DataRepository(ParsingImpl())

    val alLiveData = MutableLiveData<All>()

    fun fetchAll(context: Context) {
        viewModelScope.launch {
            val all : All = withContext(Dispatchers.IO){
                dataRepository.getAll(context)
            }
            alLiveData.value=all
        }
    }
}