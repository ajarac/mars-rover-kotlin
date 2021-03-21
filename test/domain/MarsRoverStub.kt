package domain

import com.wallapop.domain.MarsRover
import com.wallapop.domain.planet.World
import com.wallapop.domain.position.Position
import domain.planet.PlanetStub
import domain.position.PositionStub

class MarsRoverStub {
    companion object {
        fun random(position: Position = PositionStub.random(), world: World = PlanetStub.random()): MarsRover {
            return MarsRover(position = position, planet = world)
        }
    }
}
