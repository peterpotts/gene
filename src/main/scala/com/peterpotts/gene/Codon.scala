package com.peterpotts.gene

import scala.collection.immutable.Seq

case class Codon(
  first: Nucleotide,
  second: Nucleotide,
  third: Nucleotide) {
  val toSeq = Seq(first, second, third)
}

object RNACodon {
  def apply(sequence: String): Codon = {
    Codon(
      first = Ribonucleotide(sequence.charAt(0)),
      second = Ribonucleotide(sequence.charAt(1)),
      third = Ribonucleotide(sequence.charAt(2)))
  }
}

object DNACodon {
  def apply(sequence: String): Codon = {
    Codon(
      first = Deoxyribonucleotide(sequence.charAt(0)),
      second = Deoxyribonucleotide(sequence.charAt(1)),
      third = Deoxyribonucleotide(sequence.charAt(2)))
  }
}
