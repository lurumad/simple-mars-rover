package mars.rover

class Actuator {
    private val nextRight = mapOf(
        (Direction.North to Direction.East),
        (Direction.East to Direction.South),
        (Direction.South to Direction.West),
        (Direction.West to Direction.North),
    )
    private val nextLeft = mapOf(
        (Direction.North to Direction.West),
        (Direction.West to Direction.South),
        (Direction.South to Direction.East),
        (Direction.East to Direction.North),
    )
    private var direction = Direction.North

    fun direction(): Direction = direction

    fun rotateRight() {
        direction = nextRight[direction]!!
    }

    fun rotateLeft() {
        direction = nextLeft[direction]!!
    }
}