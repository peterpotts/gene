package com.peterpotts.gene

import org.scalatest.mock.MockitoSugar
import org.scalatest.{Matchers, WordSpec}

import scala.io.Source

class FastaIteratorTest extends WordSpec with Matchers with MockitoSugar {
  "A FASTA iterator" should {
    "decode FASTA format" in {
      val lines = Source.fromURL(getClass.getResource("/test.fa")).getLines()
      val actual = new FastaIterator(lines)

      val expected = Map(
        "Frag_56" -> "ATTAGACCTG",
        "Frag_57" -> "CCTGCCGGAA",
        "Frag_58" -> "AGACCTGCCG",
        "Frag_59" -> "GCCGGAATAC")

      actual.toMap shouldEqual expected
    }
  }
}
