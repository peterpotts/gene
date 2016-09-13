package com.peterpotts.gene

import scala.collection.immutable.IndexedSeq

sealed abstract class Nucleotide(val code: Char) extends Enumerated

case object Unknown extends Nucleotide('N')

sealed abstract class DeoxyriboseNucleotide(code: Char) extends Nucleotide(code)

case object Adenine extends DeoxyriboseNucleotide('A')

case object Cytosine extends DeoxyriboseNucleotide('C')

case object Guanine extends DeoxyriboseNucleotide('G')

case object Thymine extends DeoxyriboseNucleotide('T')

object Nucleotide extends Enumeration[Nucleotide] {
  val indexedSeq = IndexedSeq(
    Unknown,
    Adenine,
    Cytosine,
    Guanine,
    Thymine)

  private val map = indexedSeq.map(nucleotide => nucleotide.code -> nucleotide).toMap

  def apply(code: Char) = map(code)
}