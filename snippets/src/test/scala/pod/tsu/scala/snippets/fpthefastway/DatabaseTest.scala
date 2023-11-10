package pod.tsu.scala.snippets.fpthefastway

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class DatabaseTest extends AnyFlatSpecLike with Matchers {

  "DatabaseInFile" should "insert a record" in {

    // Given
    val db = new DatabaseInFile( ".files/database.txt" )

    // When
    val result = db.insert( "Domo Arigato" )

    // Then
    result.isSuccess shouldBe true

  }

  it should "select all records" in {

    // Given
    val db = new DatabaseInFile( ".files/database.txt" )

    // When
    val result = db.selectAll()

    // Then
    result.isSuccess shouldBe true

  }

}
