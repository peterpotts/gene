package com.peterpotts.gene

case class Codon(
  first: Nucleobase,
  second: Nucleobase,
  third: Nucleobase) {
  val toList = List(first, second, third)
}

object RNACodon {
  def apply(sequence: String) = Codon(
    first = Ribonucleoside(sequence.charAt(0)),
    second = Ribonucleoside(sequence.charAt(1)),
    third = Ribonucleoside(sequence.charAt(2)))
}

object DNACodon {
  def apply(sequence: String) = Codon(
    first = Deoxyribonucleoside(sequence.charAt(0)),
    second = Deoxyribonucleoside(sequence.charAt(1)),
    third = Deoxyribonucleoside(sequence.charAt(2)))
}
