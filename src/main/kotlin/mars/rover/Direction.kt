package mars.rover

enum class Direction(private val value: String) {
    North("N"),
    South("S"),
    East("E"),
    West("W");

    override fun toString(): String = value
}