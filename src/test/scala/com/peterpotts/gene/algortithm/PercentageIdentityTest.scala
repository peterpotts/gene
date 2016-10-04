package com.peterpotts.gene.algortithm

import com.peterpotts.gene.algorithm.PercentageIdentity
import org.scalatest.mock.MockitoSugar
import org.scalatest.{Matchers, WordSpec}

class PercentageIdentityTest extends WordSpec with Matchers with MockitoSugar {
  "Percentage identity" should {
    "measures similarity" in {
      val alignment = "THISISA-SEQUENCE" -> "TH----ATSEQUENCE"
      PercentageIdentity(alignment) shouldBe (11 * 100 / 16)
    }
  }
}

