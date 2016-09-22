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
  val seq = Seq[Nucleotide with Ribose](Adenine, Cytosine, Guanine, Uracil)
  private val map = seq.map(nucleotide => nucleotide.symbol -> nucleotide).toMap

  def apply(symbol: Char) = map(symbol)

  def get(symbol: Char) = map.get(symbol)
}

object Deoxyribonucleotide {
  val seq = Seq[Nucleotide with Deoxyribose](Adenine, Cytosine, Guanine, Thymine)
  private val map = seq.map(nucleotide => nucleotide.symbol -> nucleotide).toMap

  def apply(symbol: Char) = map(symbol)

  def get(symbol: Char) = map.get(symbol)
}