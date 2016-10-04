package com.peterpotts.gene.algorithm

object PercentageIdentity {
  def apply(alignment: (String, String)): Int = {
    val (a, b) = alignment
    val matches = (a zip b).map { case (x, y) => x == y }.count(identity)
    val length = math.max(a.length, b.length)
    (matches * 100) / length
  }
}
