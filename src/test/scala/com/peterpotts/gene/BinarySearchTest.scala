package com.peterpotts.gene

import org.scalatest.{Matchers, WordSpec}

import scala.collection.immutable.IndexedSeq

class BinarySearchTest extends WordSpec with Matchers {
  "A binary search" should {
    "find" in {
      BinarySearch.binarySearch(IndexedSeq(1, 4, 6, 7, 9), 7) shouldEqual Some(3)
    }

    "not find middle" in {
      BinarySearch.binarySearch(IndexedSeq(1, 4, 6, 7, 9), 5) shouldEqual None
    }

    "not find left" in {
      BinarySearch.binarySearch(IndexedSeq(1, 4, 6, 7, 9), 0) shouldEqual None
    }

    "not find right" in {
      BinarySearch.binarySearch(IndexedSeq(1, 4, 6, 7, 9), 10) shouldEqual None
    }

    "find first" in {
      BinarySearch.binarySearch(IndexedSeq(1, 4, 6, 7, 9), 1) shouldEqual Some(0)
    }

    "find last" in {
      BinarySearch.binarySearch(IndexedSeq(1, 4, 6, 7, 9), 9) shouldEqual Some(4)
    }
  }
}
