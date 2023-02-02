package mars.rover

class MarsRover {
    private val actuator = Actuator()
    private val wheeledBase = WheeledBase(actuator)

    fun execute(command: String): String {
        command.forEach { instruction ->
            when (instruction) {
                'R' -> actuator.rotateRight()
                'L' -> actuator.rotateLeft()
                'M' -> wheeledBase.moveForward()
            }
        }
        val direction = actuator.direction()
        val position = wheeledBase.position()
        return "${position.x}:${position.y}:${direction}"
    }
}