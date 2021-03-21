package com.wallapop.domain.world

import com.wallapop.domain.point.Point

data class World(val height: Int = 100, val width: Int = 100, val obstacles: List<Obstacle> = emptyList()) {

    fun checkPointInsideWorld(point: Point) {
        if(!(point.x in 0 until height && point.y in 0 until width)) {
            throw PointOutsideOfWorld()
        }
    }

    fun checkEncounterAnObstacle(point: Point) {
        if(obstacles.any{it.point == point}) {
            throw EncounterAnObstacleException("Encounter obstacle!")
        }
    }
}
