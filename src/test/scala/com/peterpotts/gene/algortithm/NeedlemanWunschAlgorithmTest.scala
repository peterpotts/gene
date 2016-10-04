package com.peterpotts.gene.algortithm

import com.peterpotts.gene.algorithm.NeedlemanWunschAlgorithm
import org.scalatest.mock.MockitoSugar
import org.scalatest.{Matchers, WordSpec}

class NeedlemanWunschAlgorithmTest extends WordSpec with Matchers with MockitoSugar {
  "The Needleman-Wunsch algorithm" should {
    "align nucleotide sequences" in {
      val sequences = "GCATGCU" -> "GATTACA"

      val alignments = Set(
        "GCATG-CU" -> "G-ATTACA",
        "GCA-TGCU" -> "G-ATTACA",
        "GCAT-GCU" -> "G-ATTACA")

      val alignment = NeedlemanWunschAlgorithm.align(sequences)
      (alignments contains alignment) shouldBe true
    }

    "align string sequences" in {
      val sequences = "THISISASEQUENCE" -> "THATSEQUENCE"
      val alignments = Set("THISISA-SEQUENCE" -> "TH----ATSEQUENCE")
      val alignment = NeedlemanWunschAlgorithm.align(sequences)
      (alignments contains alignment) shouldBe true
    }
  }
}

