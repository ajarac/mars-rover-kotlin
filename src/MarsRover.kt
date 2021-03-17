package com.wallapop

class MarsRover(private var position : Position = Position()) {

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
