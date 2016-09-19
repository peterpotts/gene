package com.peterpotts.gene

import scala.collection.immutable.Seq

case class Codon(
  first: Nucleotide,
  second: Nucleotide,
  third: Nucleotide) {
  val toSeq = Seq(first, second, third)
}

object Codon {
  def apply(sequence: String): Codon = {
    Codon(
      first = Nucleotide(sequence.charAt(0)),
      second = Nucleotide(sequence.charAt(1)),
      third = Nucleotide(sequence.charAt(2)))
  }
}

/**
  * START	ATG
  * STOP	TAA, TGA, TAG (Ochre, Opal, Amber)
  */