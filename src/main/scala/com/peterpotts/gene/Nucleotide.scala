package com.peterpotts.gene

sealed abstract class Nucleotide(val symbol: Char)

sealed trait Purine

sealed trait Pyrimidine

sealed trait Deoxyribose

sealed trait Ribose

case object Adenine extends Nucleotide('A') with Purine with Deoxyribose with Ribose

case object Cytosine extends Nucleotide('C') with Pyrimidine with Deoxyribose with Ribose

case object Guanine extends Nucleotide('G') with Purine with Deoxyribose with Ribose

case object Thymine extends Nucleotide('T') with Pyrimidine with Deoxyribose

case object Uracil extends Nucleotide('U') with Pyrimidine with Ribose

object Ribonucleotide {
  val list: List[Ribonucleotide] = List(Adenine, Cytosine, Guanine, Uracil)
  private val map = list.map(nucleotide => nucleotide.symbol -> nucleotide).toMap

  def apply(symbol: Char): Ribonucleotide = map(symbol)

  def get(symbol: Char): Option[Ribonucleotide] = map.get(symbol)
}

object Ribonucleotides {
  def apply(symbols: String): List[Ribonucleotide] = symbols.map(Ribonucleotide(_)).toList
}

object Deoxyribonucleotide {
  val list: List[Deoxyribonucleotide] = List(Adenine, Cytosine, Guanine, Thymine)
  private val map = list.map(nucleotide => nucleotide.symbol -> nucleotide).toMap

  def apply(symbol: Char): Deoxyribonucleotide = map(symbol)

  def get(symbol: Char): Option[Deoxyribonucleotide] = map.get(symbol)
}
