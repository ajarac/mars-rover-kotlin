package domain.planet

import com.wallapop.domain.planet.Obstacle
import com.wallapop.domain.planet.World
import shared.FakerSingleton

class PlanetStub {
    companion object {
        fun random(height: Int = FakerSingleton.randomInt(10, 100), width: Int = FakerSingleton.randomInt(10, 100), obstacles: List<Obstacle> = emptyList()): World {
            return World(height = height, width = width, obstacles =obstacles)
        }
    }
}
