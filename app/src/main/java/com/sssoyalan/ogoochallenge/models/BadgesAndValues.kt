package com.sssoyalan.ogoochallenge.models

data class BadgesAndValues(
    val value: MutableList<MutableList<Value>> = mutableListOf<MutableList<Value>>(),
    val badgesCount: BadgesCount? = null
)