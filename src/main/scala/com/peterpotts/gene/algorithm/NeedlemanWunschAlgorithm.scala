package com.peterpotts.gene.algorithm

object NeedlemanWunschAlgorithm {
  val mapMap = Map(
      'A' -> Map('A' -> 10, 'G' -> -1, 'C' -> -3, 'T' -> -4),
      'G' -> Map('A' -> -1, 'G' -> 7, 'C' -> -5, 'T' -> -3),
      'C' -> Map('A' -> -3, 'G' -> -5, 'C' -> 9, 'T' -> 0),
      'T' -> Map('A' -> -4, 'G' -> -3, 'C' -> 0, 'T' -> 8))

  def S(a: Char)(b: Char) = if (a == b) 1 else -1
//  def S(a: Char)(b: Char) =mapMap(a)(b)

  val similarity = S _

//  val A = "GCATGCU".toCharArray
//  val B = "GATTACA".toCharArray
//  val A = "AGACTAGTTAC".toCharArray
//  val B = "CGAGACGT".toCharArray



  val gapPenalty = -1
//  val gapPenalty = -5

  val d = gapPenalty

  //align("GCATGCU"->"GATTACA")

  def align(sequences: (String, String)): (String,String) = {
    val A = sequences._1.toCharArray
    val B = sequences._2.toCharArray

    val F: Array[Array[Int]] = computeMatrix(A, B)

    computeAlignment(A,B,F)
  }

  def computeMatrix(A: Array[Char], B: Array[Char]): Array[Array[Int]] = {
    val F = Array.fill(A.length + 1)(Array.fill(B.length + 1)(0))

    for (i <- 0 to A.length)
      F(i)(0) = d * i

    for (j <- 0 to B.length)
      F(0)(j) = d * j

    for (i <- 1 to A.length)
      for (j <- 1 to B.length) {
        val Match = F(i - 1)(j - 1) + S(A(i - 1))(B(j - 1))
        val Delete = F(i - 1)(j) + d
        val Insert = F(i)(j - 1) + d
        F(i)(j) = math.max(Match, math.max(Insert, Delete))
      }

    for (i <- 0 to A.length) {
      println(F(i).mkString("\t"))
    }
    F
  }

  def computeAlignment(A:Array[Char],B:Array[Char],F: Array[Array[Int]]): (String, String) = {
    var AlignmentA = ""
    var AlignmentB = ""
    var i = A.length
    var j = B.length

    while (i > 0 && j > 0) {
      if (i > 0 && j > 0 && F(i)(j) == F(i - 1)(j - 1) + S(A(i - 1))(B(j - 1))) {
        AlignmentA = A(i - 1) + AlignmentA
        AlignmentB = B(j - 1) + AlignmentB
        i = i - 1
        j = j - 1
      } else if (i > 0 && F(i)(j) == F(i - 1)(j) + d) {
        AlignmentA = A(i - 1) + AlignmentA
        AlignmentB = "-" + AlignmentB
        i = i - 1
      } else {
        AlignmentA = "-" + AlignmentA
        AlignmentB = B(j - 1) + AlignmentB
        j = j - 1
      }
    }
    (AlignmentA, AlignmentB)
  }


}
