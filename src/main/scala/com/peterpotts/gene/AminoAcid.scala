package com.peterpotts.gene

import scala.collection.immutable.Seq

sealed abstract class AminoAcid(val code: String, val symbol: Char)

case object Alanine extends AminoAcid("Ala", 'A') with AminoAcid.Nonpolar

case object Arginine extends AminoAcid("Arg", 'R') with AminoAcid.Basic

case object Asparagine extends AminoAcid("Asn", 'N') with AminoAcid.AmidePolar

case object AsparticAcid extends AminoAcid("Asp", 'D') with AminoAcid.Acidic

case object Cysteine extends AminoAcid("Cys", 'C') with AminoAcid.DisulfideNonpolar

case object Glutamine extends AminoAcid("Gln", 'Q') with AminoAcid.AmidePolar

case object GlutamicAcid extends AminoAcid("Glu", 'E') with AminoAcid.Acidic

case object Glycine extends AminoAcid("Gly", 'G') with AminoAcid.HydrogenNonpolar

case object Histidine extends AminoAcid("His", 'H') with AminoAcid.Basic

case object Isoleucine extends AminoAcid("Ile", 'I') with AminoAcid.Nonpolar

case object Leucine extends AminoAcid("Leu", 'L') with AminoAcid.Nonpolar

case object Lysine extends AminoAcid("Lys", 'K') with AminoAcid.Basic

case object Methionine extends AminoAcid("Met", 'M') with AminoAcid.Nonpolar

case object Phenylalanine extends AminoAcid("Phe", 'F') with AminoAcid.Nonpolar

case object Proline extends AminoAcid("Pro", 'P') with AminoAcid.NitrogenNonpolar

case object Serine extends AminoAcid("Ser", 'S') with AminoAcid.HydroxyPolar

case object Threonine extends AminoAcid("Thr", 'T') with AminoAcid.HydroxyPolar

case object Tryptophan extends AminoAcid("Trp", 'W') with AminoAcid.Nonpolar

case object Tyrosine extends AminoAcid("Tyr", 'Y') with AminoAcid.HydroxyPolar

case object Valine extends AminoAcid("Val", 'V') with AminoAcid.Nonpolar

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

  /**
    * Hydrophobic means does not like water.
    */
  trait Hydrophobic

  /**
    * Hydrophilic means does like water.
    */
  trait Hydrophilic

  trait Charged extends Hydrophilic

  trait PositivelyCharged extends Charged

  trait NegativelyCharged extends Charged

  trait Nonpolar extends Hydrophobic

  trait HydrogenNonpolar extends Nonpolar

  trait NitrogenNonpolar extends Nonpolar

  trait DisulfideNonpolar extends Nonpolar

  trait Polar extends Hydrophilic

  trait AmidePolar extends Polar

  trait HydroxyPolar extends Polar

  trait Acidic extends NegativelyCharged

  trait Basic extends PositivelyCharged

}
