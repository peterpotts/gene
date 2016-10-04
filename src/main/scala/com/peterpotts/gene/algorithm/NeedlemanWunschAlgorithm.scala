package com.peterpotts.gene.algorithm

import scala.collection.mutable

case class NeedlemanWunschAlgorithm(similarity: Char => Char => Int, gapPenalty: Int) {
  private val s = similarity
  private val d = gapPenalty

  def align(sequences: (String, String)): (String, String) = {
    val a = sequences._1.toArray
    val b = sequences._2.toArray
    val table = computeTable(a, b)
    computeAlignment(a, b, table)
  }

  private def computeTable(a: Array[Char], b: Array[Char]): Array[Array[Int]] = {
    val table = Array.fill(a.length + 1)(Array.fill(b.length + 1)(0))

    for (i <- 0 to a.length)
      table(i)(0) = d * i

    for (j <- 0 to b.length)
      table(0)(j) = d * j

    for (i <- 1 to a.length)
      for (j <- 1 to b.length) {
        val similar = table(i - 1)(j - 1) + s(a(i - 1))(b(j - 1))
        val delete = table(i - 1)(j) + d
        val insert = table(i)(j - 1) + d
        table(i)(j) = math.max(similar, math.max(insert, delete))
      }

    table
  }

  private def computeAlignment(a: Array[Char], b: Array[Char], table: Array[Array[Int]]): (String, String) = {
    val alignmentA = mutable.StringBuilder.newBuilder
    val alignmentB = mutable.StringBuilder.newBuilder
    var i = a.length
    var j = b.length

    while (i > 0 && j > 0) {
      if (i > 0 && j > 0 && table(i)(j) == table(i - 1)(j - 1) + s(a(i - 1))(b(j - 1))) {
        alignmentA += a(i - 1)
        alignmentB += b(j - 1)
        i -= 1
        j -= 1
      } else if (i > 0 && table(i)(j) == table(i - 1)(j) + d) {
        alignmentA += a(i - 1)
        alignmentB += '-'
        i -= 1
      } else {
        alignmentA += '-'
        alignmentB += b(j - 1)
        j -= 1
      }
    }

    alignmentA.reverse.toString -> alignmentB.reverse.toString
  }
}

object NeedlemanWunschAlgorithm extends NeedlemanWunschAlgorithm(
  similarity = (a: Char) => (b: Char) => if (a == b) 1 else -1,
  gapPenalty = -1)
