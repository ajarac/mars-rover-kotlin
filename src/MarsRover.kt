package com.wallapop

class MarsRover(private var position : Position = Position(0,0)) {

    fun getPosition(): Position {
        return position
    }

    fun moveTo(movement: Movements) {
        position = when(movement) {
            Movements.FORWARD -> Position(position.x + 1, position.y)
            Movements.BACKWARD -> Position(position.x, position.y + 1)
        }
    }
}
