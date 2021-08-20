package com.sssoyalan.ogoochallenge.api

import Rows
import android.content.Context
import com.sssoyalan.ogoochallenge.models.All
import com.sssoyalan.ogoochallenge.models.Badges

interface Api {
    suspend fun getAll(context: Context) : All
}