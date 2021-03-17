package com.wallapop

data class Position(val point: Point) {

    fun moteTo(movement: Movement): Position {
        return when(movement) {
            Movement.FORWARD -> copy(point = Point(point.x +1, point.y))
            Movement.BACKWARD -> copy(point = Point(point.x , point.y + 1))
        }
    }
}
