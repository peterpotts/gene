package com.peterpotts.gene

/**
  * A nitrogen-containing base with an identifying character symbol.
  *
  * @author Peter Potts
  */
sealed trait Nucleobase {
  val symbol: Char
}

/**
  * A nucleoside consists of a five-carbon sugar ring attached to a nitrogen-containing base.
  */
sealed trait Nucleoside extends Nucleobase {
  self: PentoseSugar =>
}

sealed trait Deoxyribonucleoside extends Nucleoside with Deoxyribose

sealed trait Ribonucleoside extends Nucleoside with Ribose

/**
  * A nucleotide consists of a five-carbon sugar ring attached to a nitrogen-containing base and a phosphate group.
  */
sealed trait Nucleotide extends Nucleoside with Phosphate {
  self: PentoseSugar =>
}

/**
  * Deoxyribonucleic acid (DNA) molecules are used to store genetic instructions that are transmitted from generation to
  * generation. A DNA molecules is a linear polymer of deoxyribonucleotides.
  */
sealed trait Deoxyribonucleotide extends Nucleotide with Deoxyribonucleoside

/**
  * Ribonucleic acid (RNA) molecules are much smaller that DNA molecules. An RNA molecules is a linear polymer of
  * ribonucleotides.
  */
sealed trait Ribonucleotide extends Nucleotide with Ribonucleoside

/**
  * A purine is a nucleobase with a 6-member and a 5-member nitrogen-containing ring.
  */
sealed trait Purine extends Nucleobase

/**
  * A pyrimidine is a nucleobase with only one 6-membered nitrogen-containing ring.
  */
sealed trait Pyrimidine extends Nucleobase

/**
  * Adenine is a purine nucleobase found in DNA and RNA.
  */
case object Adenine extends Adenine

sealed trait Adenine extends Purine {
  val symbol = 'A'
}

/**
  * Adenosine is a purine nucleoside comprising adenine attached to a ribose.
  */
case object Adenosine extends Ribonucleoside with Adenine

/**
  * Deoxyadenosine is a purine nucleoside comprising adenine attached to a deoxyribose.
  */
case object Deoxyadenosine extends Deoxyribonucleoside with Adenine

/**
  * Cytosine is a pyrimidine nucleobase found in DNA and RNA.
  */
case object Cytosine

sealed trait Cytosine extends Pyrimidine {
  val symbol = 'C'
}

/**
  * Cytidine is a pyrimidine nucleoside comprising cytosine attached to a ribose.
  */
case object Cytidine extends Ribonucleoside with Cytosine

/**
  * Deoxycytidine is a pyrimidine nucleoside comprising cytosine attached to a deoxyribose.
  */
case object Deoxycytidine extends Deoxyribonucleoside with Cytosine

/**
  * Guanine is a purine nucleobase found in DNA and RNA.
  */
case object Guanine extends Guanine

sealed trait Guanine extends Purine {
  val symbol = 'G'
}

/**
  * Guanosine is a purine nucleoside comprising guanine attached to a ribose.
  */
case object Guanosine extends Ribonucleoside with Guanine

/**
  * Deoxyguanosine is a purine nucleoside comprising guanine attached to a deoxyribose.
  */
case object Deoxyguanosine extends Deoxyribonucleoside with Guanine

/**
  * Thymine is a pyrimidine nucleobase found in DNA.
  */
case object Thymine extends Thymine

sealed trait Thymine extends Pyrimidine {
  val symbol = 'T'
}

/**
  * Deoxythymidine is a pyrimidine nucleoside comprising guanine attached to a deoxyribose.
  */
case object Deoxythymidine extends Deoxyribonucleoside with Thymine

/**
  * Uracil is a pyrimidine nucleobase found in RNA.
  */
case object Uracil extends Uracil

sealed trait Uracil extends Pyrimidine {
  val symbol = 'U'
}

/**
  * Uridine is a pyrimidine nucleoside comprising uracil attached to a ribose.
  */
case object Uridine extends Ribonucleoside with Uracil

object Ribonucleoside {
  val list: List[Ribonucleoside] = List(Adenosine, Cytidine, Guanosine, Uridine)
  private val map = list.map(nucleobase => nucleobase.symbol -> nucleobase).toMap

  def apply(symbol: Char): Ribonucleoside = map(symbol)

  def get(symbol: Char): Option[Ribonucleoside] = map.get(symbol)
}

object Ribonucleotides {
  def apply(symbols: String): List[Ribonucleoside] = symbols.map(Ribonucleoside(_)).toList
}

object Deoxyribonucleoside {
  val list: List[Deoxyribonucleoside] = List(Deoxyadenosine, Deoxycytidine, Deoxyguanosine, Deoxythymidine)
  private val map = list.map(nucleobase => nucleobase.symbol -> nucleobase).toMap

  def apply(symbol: Char): Deoxyribonucleoside = map(symbol)

  def get(symbol: Char): Option[Deoxyribonucleoside] = map.get(symbol)
}
