package domain.position

import com.wallapop.domain.point.Point
import com.wallapop.domain.position.Direction
import com.wallapop.domain.position.Position
import domain.point.PointStub

class PositionStub {
    companion object {
        fun random(point: Point = PointStub.random(), direction: Direction = DirectionStub.random()): Position {
            return Position(point = point, direction = direction)
        }
    }
}
