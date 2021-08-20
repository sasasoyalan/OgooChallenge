package com.sssoyalan.ogoochallenge.models

data class Badges(
    val value: List<Value>
)
data class Value(
    val BadgeIcon: String? = "",
    val ID: Int? = 0,
    val Id: Int? = 0,
    val Title: String? = ""
)