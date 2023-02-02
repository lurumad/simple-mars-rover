import io.kotest.core.spec.style.FreeSpec
import io.kotest.inspectors.forAll
import mars.rover.MarsRover
import org.amshove.kluent.shouldBeEqualTo

class MarsRoverTest : FreeSpec({
    "mars rover" - {
        listOf(
            "R" to "0:0:E",
            "RR" to "0:0:S",
            "RRR" to "0:0:W",
            "RRRR" to "0:0:N"
        ).forAll { (command, output) ->
            "it should execute the command ($command) rotating the direction is facing to the right ($output)" {
                val marsRover = MarsRover()
                val result = marsRover.execute(command)
                result shouldBeEqualTo output
            }
        }

        listOf(
            "L" to "0:0:W",
            "LL" to "0:0:S",
            "LLL" to "0:0:E",
            "LLLL" to "0:0:N"
        ).forAll { (command, output) ->
            "it should execute the command ($command) rotating the direction is facing to the left ($output)" {
                val marsRover = MarsRover()
                val result = marsRover.execute(command)
                result shouldBeEqualTo output
            }
        }

        listOf(
            "M" to "0:1:N",
            "MM" to "0:2:N",
            "MMMMMMMMMM" to "0:0:N",
            "RRM" to "0:9:S",
            "MMRRMM" to "0:0:S",
            "RMM" to "2:0:E",
            "RMMMMMMMMMM" to "0:0:E",
            "RRRM" to "9:0:W",
            "RMMRRMM" to "0:0:W",
            "LM" to "9:0:W",
            "LLM" to "0:9:S",
            "MMRMMLM" to "2:3:N"
        ).forAll { (command, output) ->
            "it should execute the command ($command) moving forward in the direction it is currently facing to ($output)" {
                val marsRover = MarsRover()
                val result = marsRover.execute(command)
                result shouldBeEqualTo output
            }
        }
    }
})