package com.peterpotts.gene

import scala.collection.immutable.IndexedSeq

sealed abstract class NucleicAcid(val code: Char) extends Enumerated

case object Unknown extends NucleicAcid('N')

sealed abstract class DNA(code: Char) extends NucleicAcid(code)

case object Adenine extends DNA('A')

case object Cytosine extends DNA('C')

case object Guanine extends DNA('G')

case object Thymine extends DNA('T')

object NucleicAcid extends Enumeration[NucleicAcid] {
  val indexedSeq = IndexedSeq(
    Unknown,
    Adenine,
    Cytosine,
    Guanine,
    Thymine)
}