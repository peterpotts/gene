package com.peterpotts.gene

import scala.collection.immutable.IndexedSeq

sealed abstract class AminoAcid(val abbreviation: String, val code: Char, codons: Set[String]) extends Enumerated

case object Alanine extends AminoAcid("Ala", 'A', Set("GCT", "GCC", "GCA", "GCG"))
case object Arginine extends AminoAcid("Arg", 'R', Set("CGT", "CGC", "CGA", "CGG", "AGA", "AGG"))
case object Asparagine extends AminoAcid("Asn", 'N', Set("AAT", "AAC"))
case object AsparticAcid extends AminoAcid("Asp", 'D', Set("GAT", "GAC"))
case object Cysteine extends AminoAcid("Cys", 'C', Set("TGT", "TGC"))
case object Glutamine extends AminoAcid("Gln", 'Q', Set("CAA, CAG"))
case object GlutamicAcid extends AminoAcid("Glu", 'E', Set("GAA", "GAG"))
case object Glycine extends AminoAcid("Gly", 'G', Set("GGT", "GGC", "GGA", "GGG"))
case object Histidine extends AminoAcid("His", 'H', Set("CAT", "CAC"))
case object Isoleucine extends AminoAcid("Ile", 'I', Set("ATT", "ATC", "ATA"))
case object Leucine extends AminoAcid("Leu", 'L', Set("TTA", "TTG", "CTT", "CTC", "CTA", "CTG"))
case object Lysine extends AminoAcid("Lys", 'K', Set("AAA", "AAG"))
case object Methionine extends AminoAcid("Met", 'M', Set("ATG"))
case object Phenylalanine extends AminoAcid("Phe", 'F', Set("TTT", "TTC"))
case object Proline extends AminoAcid("Pro", 'P', Set("CCT", "CCC", "CCA", "CCG"))
case object Serine extends AminoAcid("Ser", 'S', Set("TCT", "TCC", "TCA", "TCG", "AGT, AGC"))
case object Threonine extends AminoAcid("Thr", 'T', Set("ACT", "ACC", "ACA", "ACG"))
case object Tryptophan extends AminoAcid("Trp", 'W', Set("TGG"))
case object Tyrosine extends AminoAcid("Tyr", 'Y', Set("TAT", "TAC"))
case object Valine extends AminoAcid("Val", 'V', Set("GTT", "GTC", "GTA", "GTG"))

case object Selenocysteine extends AminoAcid("Sec", 'U', Set("UGA"))
case object Pyrrolysine extends AminoAcid("Pyl", 'O', Set("UAG"))

object AminoAcid extends Enumeration[AminoAcid] {
  val indexedSeq = IndexedSeq(
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

  private val map = indexedSeq.map(aminoAcid => aminoAcid.code -> aminoAcid).toMap

  def apply(code: Char) = map(code)
}