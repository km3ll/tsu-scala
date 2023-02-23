package pod.typelevel.typeclass.state

import cats.data.State

// Reference: https://typelevel.org/cats/datatypes/state.html
object StateDomain {

  final case class Robot(
    id:   Long,
    name: String
  )

  final case class Seed( long: Long ) {
    def next(): Seed = {
      Seed( long * 6364136223846793005L + 1442695040888963407L )
    }
  }

  // Seed
  def nextLong( seed: Seed ): ( Seed, Long ) = {
    ( seed.next(), seed.long )
  }
  def nextBoolean( seed: Seed ): ( Seed, Boolean ) = {
    ( seed.next(), seed.long >= 0L )
  }
  def buildRobot( seed: Seed ): Robot = {
    val ( seed1, id ) = nextLong( seed )
    val ( seed2, isCatherine ) = nextBoolean( seed1 )
    val name = if ( isCatherine ) "Catherine" else "Carlos"
    println( s"Seeds: [ 0: $seed, 1: $seed1, 2: $seed2 ]" )
    Robot( id, name )
  }

  // State
  val nextLong: State[Seed, Long] = State {
    seed => ( seed.next(), seed.long )
  }
  // The map method on State allows us to transform the A value without affecting the S (state) value.
  // This is perfect for implementing nextBoolean in terms of nextLong.
  val nextBoolean: State[Seed, Boolean] = nextLong.map { long => long >= 0 }

  // The flatMap method on State[S, A] lets you use the result of one State in a subsequent State.
  // The updated state (S) after the first call is passed into the second call. T
  val buildRobot: State[Seed, Robot] = {
    for {
      id <- nextLong
      isCatherine <- nextBoolean
      name = if ( isCatherine ) "Catherine" else "Carlos"
    } yield Robot( id, name )
  }

}
