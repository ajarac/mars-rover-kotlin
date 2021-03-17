package com.wallapop

enum class Direction {
    NORTH, EAST, SOUTH, WEST;

    fun moveToLeft(): Direction = values()[(ordinal + values().size - 1) % values().size]
    fun moveToRight(): Direction = values()[(ordinal + 1) % values().size]
}
