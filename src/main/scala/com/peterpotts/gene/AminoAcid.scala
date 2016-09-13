package com.peterpotts.gene

import scala.collection.immutable.IndexedSeq

sealed abstract class AminoAcid(val code: Char) extends Enumerated

case object Alanine extends AminoAcid('A')

case object Cysteine extends AminoAcid('C')

case object AsparticAcid extends AminoAcid('D')

case object GlutamicAcid extends AminoAcid('E')

case object Phenylalanine extends AminoAcid('F')

case object Glycine extends AminoAcid('G')

case object Histidine extends AminoAcid('H')

case object Isoleucine extends AminoAcid('I')

case object Lysine extends AminoAcid('K')

case object Leucine extends AminoAcid('L')

case object Methionine extends AminoAcid('M')

case object Asparagine extends AminoAcid('A')

case object Pyrrolysine extends AminoAcid('O')

case object Proline extends AminoAcid('P')

case object Glutamine extends AminoAcid('Q')

case object Arginine extends AminoAcid('A')

case object Serine extends AminoAcid('S')

case object Threonine extends AminoAcid('T')

case object Selenocysteine extends AminoAcid('U')

case object Valine extends AminoAcid('V')

case object Tryptophan extends AminoAcid('W')

case object Tyrosine extends AminoAcid('Y')

object AminoAcid extends Enumeration[AminoAcid] {
  val indexedSeq = IndexedSeq(
    Alanine,
    Cysteine,
    AsparticAcid,
    GlutamicAcid,
    Phenylalanine,
    Glycine,
    Histidine,
    Isoleucine,
    Lysine,
    Leucine,
    Methionine,
    Asparagine,
    Pyrrolysine,
    Proline,
    Glutamine,
    Arginine,
    Serine,
    Threonine,
    Selenocysteine,
    Valine,
    Tryptophan,
    Tyrosine)
}