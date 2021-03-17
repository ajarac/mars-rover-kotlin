package com.wallapop

data class Position(val point: Point = Point(0, 0), val direction: Direction = Direction.NORTH) {

    fun moteTo(movement: Movement): Position {
        return when(movement) {
            Movement.FORWARD -> copy(point = Point(point.x + 1, point.y))
            Movement.BACKWARD -> copy(point = Point(point.x , point.y + 1))
        }
    }

    fun rotateTo(rotate: Rotate): Position {
        return when (rotate) {
            Rotate.LEFT -> copy(direction = direction.moveToLeft())
            Rotate.RIGHT -> copy(direction = direction.moveToRight())
        }
    }
}
