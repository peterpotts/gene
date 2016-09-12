package com.peterpotts.gene

import scala.io.Source

object Application {
  def main(args: Array[String]): Unit = {
    val lines = Source.fromURL(getClass.getResource("/chr21.fa")).getLines()
    val fragments = new FastaIterator(lines).map(Fragment.tupled)
    fragments.foreach(println)
  }
}
