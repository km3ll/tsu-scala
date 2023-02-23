package pod.typelevel.typeclass.state

import org.scalatest.funsuite.AnyFunSuite
import StateDomain._

class StateTests extends AnyFunSuite {

  test( "Build robot using Seed" ) {
    val seed = Seed( 27L )
    val robot = buildRobot( seed )
    println( s"Robot: $robot" )
    assert( robot.id == seed.long )
  }

  test( "Build robot using State.run" ) {
    // Given
    val seed = Seed( 32L )
    // When
    val ( state, robot ) = buildRobot.run( seed ).value
    // Then
    println( s"Initial state: $seed, final state: $state, robot: $robot" )
    assert( robot.id == seed.long )
  }

  test( "Build robot using State.runA" ) {
    // Given
    val seed = Seed( 32L )
    // When
    // runA: Run with the provided initial state value and return the final value (discarding the final state).
    val robot = buildRobot.runA( seed ).value
    // Then
    println( s"Initial state: $seed, robot: $robot" )
    assert( robot.id == seed.long )
  }

}
