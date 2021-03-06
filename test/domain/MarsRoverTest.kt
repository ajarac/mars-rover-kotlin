package domain

import com.wallapop.domain.MarsRover
import com.wallapop.domain.world.EncounterAnObstacleException
import com.wallapop.domain.world.Obstacle
import com.wallapop.domain.world.World
import com.wallapop.domain.point.Point
import com.wallapop.domain.position.*
import com.wallapop.domain.world.PointOutsideOfWorld
import org.junit.Test;

import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.invoking
import org.amshove.kluent.shouldThrow


class MarsRoverTest {

    @Test
    fun `Mars rover should initialize at position 0,0 and north`() {
        val rover = MarsRover()
        rover.getPosition() `should be equal to` Position(Point(0, 0), Direction.NORTH)
    }

    @Test
    fun `Mars rover should move forward and north` () {
        val rover = MarsRover()

        rover.moveTo(Movement.FORWARD)

        rover.getPosition() `should be equal to` Position(Point(1, 0), Direction.NORTH)
    }

    @Test
    fun `Mars rover should move to backward and north` () {
        val rover = MarsRover()

        rover.moveTo(Movement.BACKWARD)

        rover.getPosition() `should be equal to` Position(Point(99, 0), Direction.NORTH)
    }

    @Test
    fun `Mars rover should rotate to left, north to west`() {
        val rover = MarsRover()

        rover.rotateTo(Rotate.LEFT)

        rover.getPosition() `should be equal to` Position(Point(0, 0), Direction.WEST)
    }

    @Test
    fun `Mars rover should rotate to right, north to east`() {
        val rover = MarsRover()

        rover.rotateTo(Rotate.RIGHT)

        rover.getPosition() `should be equal to` Position(Point(0, 0), Direction.EAST)
    }

    @Test
    fun `Mars rover should rotate to right, south to west`() {
        val rover = MarsRover(position = Position(direction = Direction.SOUTH))

        rover.rotateTo(Rotate.RIGHT)

        rover.getPosition() `should be equal to` Position(Point(0, 0), Direction.WEST)
    }

    @Test
    fun `Mars rover should rotate to right and then move to forward`() {
        val rover = MarsRover()

        rover.rotateTo(Rotate.RIGHT)
        rover.moveTo(Movement.FORWARD)

        rover.getPosition() `should be equal to` Position(Point(0, 99), Direction.EAST)
    }

    @Test
    fun `Mars rover should rotate to left and then move to backward`() {
        val rover = MarsRover()

        rover.rotateTo(Rotate.LEFT)
        rover.moveTo(Movement.BACKWARD)

        rover.getPosition() `should be equal to` Position(Point(0, 99), Direction.WEST)
    }

    @Test
    fun `Mars rover should initialize at mars with world 100 x 100 size`() {
        val rover = MarsRover()

        rover.getWorld() `should be equal to` World(100, 100)
    }

    @Test
    fun `Should throw error if the position if outside of world`() {
        invoking { MarsRover(position = Position(point = Point(500, 500)), World(100, 100)) } shouldThrow PointOutsideOfWorld::class
    }

    @Test
    fun `Mars rover when arrive at the limit, should be on the other side`() {
        val rover = MarsRover(position = Position(point = Point(99, 99)))

        rover.moveTo(Movement.FORWARD)

        rover.getPosition() `should be equal to` Position(point = Point(0, 99))
    }

    @Test
    fun `Mars rover when arrive at the back limit and move backward, should be at the other side`() {
        val rover = MarsRover(position = Position(point = Point(0, 0)))

        rover.moveTo(Movement.BACKWARD)

        rover.getPosition() `should be equal to` Position(point = Point(99, 0))
    }

    @Test
    fun `Mars rover should stay at the same position if when moves encounters an obstacle`() {
        val obstaclesList: ArrayList<Obstacle> = arrayListOf(Obstacle(point = Point(1, 0)))
        val rover = MarsRover(world = World( obstacles = obstaclesList))

        invoking {rover.moveTo(Movement.FORWARD) } shouldThrow EncounterAnObstacleException::class

        rover.getPosition() `should be equal to` Position(point= Point(0, 0))
    }
}
