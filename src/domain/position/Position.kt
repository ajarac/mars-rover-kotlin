package com.wallapop.domain.position

import com.wallapop.domain.world.World
import com.wallapop.domain.point.Point

data class Position(val point: Point = Point(0, 0), val direction: Direction = Direction.NORTH) {

    companion object {
        private fun vectorDirection(direction: Direction): Point {
            return when (direction) {
                Direction.NORTH -> Point(1, 0)
                Direction.EAST -> Point(0, -1)
                Direction.SOUTH -> Point(-1, 0)
                Direction.WEST -> Point(0, 1)
            }
        }
    }

    fun moteTo(movement: Movement, world: World): Position {
        val vectorDirection: Point = vectorDirection(direction)
        val newPosition: Position = when(movement) {
            Movement.FORWARD -> copy(point = point.add(vectorDirection).normalize(world.height, world.width))
            Movement.BACKWARD -> copy(point = point.subtract(vectorDirection).normalize(world.height, world.width))
        }

        world.checkEncounterAnObstacle(newPosition.point)

        return newPosition
    }

    fun rotateTo(rotate: Rotate): Position {
        return when (rotate) {
            Rotate.LEFT -> copy(direction = direction.moveToLeft())
            Rotate.RIGHT -> copy(direction = direction.moveToRight())
        }
    }
}
