package com.peterpotts.gene

case class Codon(
  first: Nucleotide,
  second: Nucleotide,
  third: Nucleotide) {
  val toList = List(first, second, third)
}

object RNACodon {
  def apply(sequence: String) = Codon(
    first = Ribonucleotide(sequence.charAt(0)),
    second = Ribonucleotide(sequence.charAt(1)),
    third = Ribonucleotide(sequence.charAt(2)))
}

object DNACodon {
  def apply(sequence: String) = Codon(
    first = Deoxyribonucleotide(sequence.charAt(0)),
    second = Deoxyribonucleotide(sequence.charAt(1)),
    third = Deoxyribonucleotide(sequence.charAt(2)))
}
