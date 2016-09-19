package com.peterpotts.gene

import scala.collection.immutable.Seq

case class Codon(
  first: Nucleobase,
  second: Nucleobase,
  third: Nucleobase) {
  val toSeq = Seq(first, second, third)
}

object Codon {
  def apply(sequence: String): Codon = {
    Codon(
      first = Nucleobase(sequence.charAt(0)),
      second = Nucleobase(sequence.charAt(1)),
      third = Nucleobase(sequence.charAt(2)))
  }
}

/**
  * START	ATG
  * STOP	TAA, TGA, TAG (Ochre, Opal, Amber)
  */