package com.peterpotts.gene

sealed abstract class AminoAcid(val code: String, val symbol: Char) extends Serializable

case object Alanine extends AminoAcid("Ala", 'A') with AminoAcid.Nonpolar

case object Arginine extends AminoAcid("Arg", 'R') with AminoAcid.Basic

case object Asparagine extends AminoAcid("Asn", 'N') with AminoAcid.Amide

case object AsparticAcid extends AminoAcid("Asp", 'D') with AminoAcid.Acidic

case object Cysteine extends AminoAcid("Cys", 'C') with AminoAcid.Disulfide

case object Glutamine extends AminoAcid("Gln", 'Q') with AminoAcid.Amide

case object GlutamicAcid extends AminoAcid("Glu", 'E') with AminoAcid.Acidic

case object Glycine extends AminoAcid("Gly", 'G') with AminoAcid.Hydrogen

case object Histidine extends AminoAcid("His", 'H') with AminoAcid.Basic

case object Isoleucine extends AminoAcid("Ile", 'I') with AminoAcid.Nonpolar

case object Leucine extends AminoAcid("Leu", 'L') with AminoAcid.Nonpolar

case object Lysine extends AminoAcid("Lys", 'K') with AminoAcid.Basic

case object Methionine extends AminoAcid("Met", 'M') with AminoAcid.Nonpolar

case object Phenylalanine extends AminoAcid("Phe", 'F') with AminoAcid.Nonpolar

case object Proline extends AminoAcid("Pro", 'P') with AminoAcid.Nitrogen

case object Serine extends AminoAcid("Ser", 'S') with AminoAcid.Hydroxy

case object Threonine extends AminoAcid("Thr", 'T') with AminoAcid.Hydroxy

case object Tryptophan extends AminoAcid("Trp", 'W') with AminoAcid.Nonpolar

case object Tyrosine extends AminoAcid("Tyr", 'Y') with AminoAcid.Hydroxy

case object Valine extends AminoAcid("Val", 'V') with AminoAcid.Nonpolar

case object Selenocysteine extends AminoAcid("Sec", 'U')

case object Pyrrolysine extends AminoAcid("Pyl", 'O')

object AminoAcid {
  val list = List(
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

  private val codeToAminoAcid = list.map(aminoAcid => aminoAcid.code -> aminoAcid).toMap

  def apply(code: String): AminoAcid = codeToAminoAcid(code)

  def get(code: String): Option[AminoAcid] = codeToAminoAcid.get(code)

  private val symbolToAminoAcid = list.map(aminoAcid => aminoAcid.symbol -> aminoAcid).toMap

  def apply(symbol: Char): AminoAcid = symbolToAminoAcid(symbol)

  def get(symbol: Char): Option[AminoAcid] = symbolToAminoAcid.get(symbol)

  /**
    * Hydrophobic means does not like water.
    */
  trait Hydrophobic

  /**
    * Hydrophilic means does like water.
    */
  trait Hydrophilic

  trait Charged extends Hydrophilic

  trait Positive extends Charged

  trait Negative extends Charged

  trait Uncharged

  trait Neutral extends Uncharged

  trait Nonpolar extends Neutral with Hydrophobic

  trait Hydrogen extends Nonpolar

  trait Nitrogen extends Nonpolar

  trait Disulfide extends Nonpolar

  trait Polar extends Neutral with Hydrophilic

  trait Amide extends Polar

  trait Hydroxy extends Polar

  trait Acidic extends Negative

  trait Basic extends Positive

}
