package com.peterpotts.gene

import scala.collection.immutable.Seq

sealed abstract class AminoAcid(val code: String, val symbol: Char)

case object Alanine extends AminoAcid("Ala", 'A')

case object Arginine extends AminoAcid("Arg", 'R')

case object Asparagine extends AminoAcid("Asn", 'N')

case object AsparticAcid extends AminoAcid("Asp", 'D')

case object Cysteine extends AminoAcid("Cys", 'C')

case object Glutamine extends AminoAcid("Gln", 'Q')

case object GlutamicAcid extends AminoAcid("Glu", 'E')

case object Glycine extends AminoAcid("Gly", 'G')

case object Histidine extends AminoAcid("His", 'H')

case object Isoleucine extends AminoAcid("Ile", 'I')

case object Leucine extends AminoAcid("Leu", 'L')

case object Lysine extends AminoAcid("Lys", 'K')

case object Methionine extends AminoAcid("Met", 'M')

case object Phenylalanine extends AminoAcid("Phe", 'F')

case object Proline extends AminoAcid("Pro", 'P')

case object Serine extends AminoAcid("Ser", 'S')

case object Threonine extends AminoAcid("Thr", 'T')

case object Tryptophan extends AminoAcid("Trp", 'W')

case object Tyrosine extends AminoAcid("Tyr", 'Y')

case object Valine extends AminoAcid("Val", 'V')

case object Selenocysteine extends AminoAcid("Sec", 'U')

case object Pyrrolysine extends AminoAcid("Pyl", 'O')

object AminoAcid {
  val seq = Seq(
    Alanine,
    Arginine,
    Asparagine,
    AsparticAcid,
    Cysteine,
    Glutamine,
    GlutamicAcid,
    Glycine,
    Histidine,
    Isoleucine,
    Leucine,
    Lysine,
    Methionine,
    Phenylalanine,
    Proline,
    Serine,
    Threonine,
    Tryptophan,
    Tyrosine,
    Valine,
    Selenocysteine,
    Pyrrolysine)

  private val codeToAminoAcid = seq.map(aminoAcid => aminoAcid.code -> aminoAcid).toMap

  def apply(code: String) = codeToAminoAcid(code)

  def get(code: String) = codeToAminoAcid.get(code)

  private val symbolToAminoAcid = seq.map(aminoAcid => aminoAcid.symbol -> aminoAcid).toMap

  def apply(symbol: Char) = symbolToAminoAcid(symbol)

  def get(symbol: Char) = symbolToAminoAcid.get(symbol)
}
