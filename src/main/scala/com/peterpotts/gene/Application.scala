package com.peterpotts.gene

import scala.io.Source

object Application {
  def main(args: Array[String]): Unit = {
    val lines = Source.fromURL(getClass.getResource("/chr21.fa")).getLines()
    val fragments = new FastaIterator(lines).map(Fragment.tupled)
    val chromosome = fragments.next().value
    val letters = chromosome.toUpperCase.toSet
    println(letters)
  }
}
