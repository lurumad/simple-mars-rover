package mars.rover

class WheeledBase(private val actuator: Actuator) {
    private var position = Position(0, 0)
    fun position(): Position = position
    fun moveForward() {
        when (actuator.direction()) {
            Direction.North -> if (position.y < 9) position.y += 1 else position.y = 0
            Direction.South -> if (position.y > 0) position.y -= 1 else position.y = 9
            Direction.East ->  if (position.x < 9) position.x += 1 else position.x = 0
            Direction.West ->  if (position.x > 0) position.x -= 1 else position.x = 9
         }
    }
}