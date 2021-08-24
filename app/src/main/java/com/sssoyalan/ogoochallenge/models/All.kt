package com.sssoyalan.ogoochallenge.models

import Row

data class All (
    val rows: List<Row>,
    val badgesCountValue: List<Value>,
    var badgesList: List<BadgeModel>,
    var totalRating : Float = 0f
)