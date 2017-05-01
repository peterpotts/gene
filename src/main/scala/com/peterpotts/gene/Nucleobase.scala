package com.peterpotts.gene

/**
  * A nucleotide consists of a five-carbon sugar ring attached to a nitrogen-containing base and a phosphate group.
  * In DNA, the sugar is deoxyribose, in RNA it is ribose. Ribose has an additional hydroxyl group attached to the
  * five-carbon sugar ring. It is the phosphate group that is involved in linking the building blocks together by
  * a phosphodiester linkage in DNA. The nitrogen-containing base is also known as the nucleobase.
  *
  * Nucleoside = Sugar + Nucleobase
  * Nucleotide = Sugar + Nucleobase + Phosphate
  */
sealed abstract class Nucleobase(val symbol: Char)

/**
  * A purine is a nucleobase with a 6-member and a 5-member nitrogen-containing ring.
  */
sealed abstract class Purine(symbol: Char) extends Nucleobase(symbol)

/**
  * A pyrimidine is a nucleobase with only one 6-membered nitrogen-containing ring.
  */
sealed abstract class Pyrimidine(symbol: Char) extends Nucleobase(symbol)

sealed trait Sugar

/**
  * Five-carbon sugar ring without hydroxyl group.
  */
sealed trait Deoxyribose extends Sugar

/**
  * Five-carbon sugar ring with hydroxyl group.
  */
sealed trait Ribose extends Sugar

/**
  * Adenine forms the nucleoside adenosine with ribose and deoxyadenosine with deoxyribose.
  */
case object Adenine extends Purine('A') with Deoxyribose with Ribose

/**
  * The nucleoside of cytosine is cytidine.
  */
case object Cytosine extends Pyrimidine('C') with Deoxyribose with Ribose

/**
  * The nucleoside of guanine is guanosine.
  */
case object Guanine extends Purine('G') with Deoxyribose with Ribose

/**
  * Thymine binds with a deoxyribose sugar to form the nucleoside deoxythymidine.
  */
case object Thymine extends Pyrimidine('T') with Deoxyribose

/**
  * Uracil binds with a ribose sugar to form the ribonucleoside uridine.
  */
case object Uracil extends Pyrimidine('U') with Ribose

/**
  * Ribonucleic acid (RNA) molecules are much smaller that DNA molecules. An RNA molecules is a linear polymer of 4
  * different ribonucleotide building blocks.
  */
object Ribonucleotide {
  val list: List[Ribonucleoside] = List(Adenine, Cytosine, Guanine, Uracil)
  private val map = list.map(nucleotide => nucleotide.symbol -> nucleotide).toMap

  def apply(symbol: Char): Ribonucleoside = map(symbol)

  def get(symbol: Char): Option[Ribonucleoside] = map.get(symbol)
}

object Ribonucleotides {
  def apply(symbols: String): List[Ribonucleoside] = symbols.map(Ribonucleotide(_)).toList
}

/**
  * Deoxyribonucleic acid (DNA) molecules are used to store genetic instructions that are transmitted from generation to
  * generation. A DNA molecules is a linear polymer of 4 different deoxyribonucleotide building blocks.
  */
object Deoxyribonucleotide {
  val list: List[Deoxyribonucleoside] = List(Adenine, Cytosine, Guanine, Thymine)
  private val map = list.map(nucleotide => nucleotide.symbol -> nucleotide).toMap

  def apply(symbol: Char): Deoxyribonucleoside = map(symbol)

  def get(symbol: Char): Option[Deoxyribonucleoside] = map.get(symbol)
}
