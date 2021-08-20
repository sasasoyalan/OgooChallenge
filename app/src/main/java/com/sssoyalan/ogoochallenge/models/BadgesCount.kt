package com.sssoyalan.ogoochallenge.models

data class BadgesCount (
    val badge3 : Badge3 = Badge3(0,0,0f),
    val badge4 : Badge4 = Badge4(0,0,0f),
    val badge5 : Badge5 = Badge5(0,0,0f),
    val badge6 : Badge6 = Badge6(0,0,0f),
    val badge7 : Badge7 = Badge7(0,0,0f),
    val badge8 : Badge8 = Badge8(0,0,0f),
    val badge9 : Badge9 = Badge9(0,0,0f),
    val badge10 : Badge10 = Badge10(0,0,0f),
    val badge11 : Badge11 = Badge11(0,0,0f)
)

data class Badge3(
    var count : Int = 0,
    var total : Int = 0,
    var avarage : Float = 0f
)
data class Badge4(
        var count : Int = 0,
        var total : Int = 0,
        var avarage : Float = 0f
)
data class Badge5(
        var count : Int = 0,
        var total : Int = 0,
        var avarage : Float = 0f
)
data class Badge6(
        var count : Int = 0,
        var total : Int = 0,
        var avarage : Float = 0f
)
data class Badge7(
        var count : Int = 0,
        var total : Int = 0,
        var avarage : Float = 0f
)
data class Badge8(
        var count : Int = 0,
        var total : Int = 0,
        var avarage : Float = 0f
)
data class Badge9(
        var count : Int = 0,
        var total : Int = 0,
        var avarage : Float = 0f
)
data class Badge10(
        var count : Int = 0,
        var total : Int = 0,
        var avarage : Float = 0f
)
data class Badge11(
        var count : Int = 0,
        var total : Int = 0,
        var avarage : Float = 0f
)
