package com.peterpotts.gene

import scala.collection.immutable.Seq

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
  val seq = Seq[Ribonucleotide](Adenine, Cytosine, Guanine, Uracil)
  private val map = seq.map(nucleotide => nucleotide.symbol -> nucleotide).toMap

  def apply(symbol: Char) = map(symbol)

  def get(symbol: Char) = map.get(symbol)
}

object Ribonucleotides {
  def apply(symbols: String): Seq[Ribonucleotide] = symbols.map(Ribonucleotide(_))
}

object Deoxyribonucleotide {
  val seq = Seq[Deoxyribonucleotide](Adenine, Cytosine, Guanine, Thymine)
  private val map = seq.map(nucleotide => nucleotide.symbol -> nucleotide).toMap

  def apply(symbol: Char) = map(symbol)

  def get(symbol: Char) = map.get(symbol)
}
