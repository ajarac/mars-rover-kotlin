package com.wallapop

class MarsRover(private var position : Position = Position(Point(0,0), Direction.NORTH)) {

    fun getPosition(): Position {
        return position
    }

    fun moveTo(movement: Movement) {
        position = position.moteTo(movement)
    }

    fun rotateTo(rotate: Rotate) {
        position = position.rotateTo(rotate)
    }

}
