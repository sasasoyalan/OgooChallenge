package com.sssoyalan.ogoochallenge.source

import Rows
import android.content.Context
import com.sssoyalan.ogoochallenge.api.Api
import com.sssoyalan.ogoochallenge.models.All
import com.sssoyalan.ogoochallenge.models.Badges

class DataRepository(private val api : Api) {

    suspend fun getAll(context: Context) : All {
        return api.getAll(context)
    }
}