package com.wallapop.domain.world

import com.wallapop.domain.point.Point

data class World(val height: Int, val width: Int, val obstacles: List<Obstacle> = emptyList()) {

    fun checkEncounterAnObstacle(point: Point) {
        if(obstacles.any{it.point == point}) {
            throw EncounterAnObstacleException("Encounter obstacle!")
        }
    }
}
