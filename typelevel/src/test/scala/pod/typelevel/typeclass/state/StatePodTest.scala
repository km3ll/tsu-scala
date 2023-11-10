package pod.typelevel.typeclass.state

import org.scalatest.funsuite.AnyFunSuite
import StatePod._

class StatePodTest extends AnyFunSuite {

  test( "Build robot using Seed" ) {
    val seed = Seed( 27L )
    val robot = buildRobot( seed )
    println( s"Robot: $robot" )
    assert( robot.id == seed.long )
  }

  test( "Build robot using State.run" ) {
    val seed = Seed( 32L )
    val ( state, robot ) = buildRobot.run( seed ).value
    println( s"Initial state: $seed, final state: $state, robot: $robot" )
    assert( robot.id == seed.long )
  }

  test( "Build robot using State.runA" ) {
    val seed = Seed( 32L )
    // runA: Run with the provided initial state value and return the final value (discarding the final state).
    val robot = buildRobot.runA( seed ).value
    println( s"Initial state: $seed, robot: $robot" )
    assert( robot.id == seed.long )
  }

}
