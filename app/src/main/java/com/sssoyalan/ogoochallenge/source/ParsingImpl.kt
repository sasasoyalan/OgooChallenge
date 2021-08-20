package com.sssoyalan.ogoochallenge.source

import Row
import Rows
import RowwModel
import android.content.Context
import android.content.res.AssetManager
import com.google.gson.Gson
import com.sssoyalan.ogoochallenge.api.Api
import com.sssoyalan.ogoochallenge.models.All
import com.sssoyalan.ogoochallenge.models.Badges
import com.sssoyalan.ogoochallenge.models.BadgesCount
import org.json.JSONObject


class ParsingImpl : Api {

    override suspend fun getAll(context: Context): All {
        fun AssetManager.readFile(fileName: String) = open(fileName)
            .bufferedReader()
            .use { it.readText() }
        val jsonStringBadge = context.assets.readFile("badge-data.json")
        val jsonStringList = context.assets.readFile("list-data.json")

        return All(Gson().fromJson(jsonStringList, RowwModel::class.java).Row,Gson().fromJson(jsonStringBadge, Badges::class.java).value)
    }

}