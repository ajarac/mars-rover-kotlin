package domain.world

import com.wallapop.domain.world.Obstacle
import com.wallapop.domain.world.World
import shared.FakerSingleton

class PlanetStub {
    companion object {
        fun random(height: Int = FakerSingleton.randomInt(10, 100), width: Int = FakerSingleton.randomInt(10, 100), obstacles: List<Obstacle> = emptyList()): World {
            return World(height = height, width = width, obstacles =obstacles)
        }
    }
}
