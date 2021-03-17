package com.wallapop

import com.wallapop.position.Movement
import com.wallapop.position.Position
import com.wallapop.position.Rotate

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
