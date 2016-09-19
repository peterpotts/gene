package com.peterpotts.gene

import scala.collection.immutable.IndexedSeq

sealed abstract class Nucleobase(val symbol: Char) extends Enumerated

sealed trait Purine

sealed trait Pyrimidine

sealed trait Deoxyribose

sealed trait Ribose

case object Adenine extends Nucleobase('A') with Purine with Deoxyribose with Ribose

case object Cytosine extends Nucleobase('C') with Pyrimidine with Deoxyribose with Ribose

case object Guanine extends Nucleobase('G') with Purine with Deoxyribose with Ribose

case object Thymine extends Nucleobase('T') with Pyrimidine with Deoxyribose

case object Uracil extends Nucleobase('T') with Pyrimidine with Ribose

object Nucleobase extends Enumeration[Nucleobase] {
  val indexedSeq = IndexedSeq(
    Adenine,
    Cytosine,
    Guanine,
    Thymine,
    Uracil)

  private val map = indexedSeq.map(nucleobase => nucleobase.symbol -> nucleobase).toMap

  def apply(code: Char) = map(code)
}