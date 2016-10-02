package com.peterpotts.gene

import scala.collection.immutable.Seq

sealed abstract class DeoxyribonucleotideUncertainty(
  val symbol: Char,
  deoxyribonucleotides: Seq[Nucleotide with Deoxyribose])

case object M extends DeoxyribonucleotideUncertainty('M', Deoxyribonucleotides("AC"))

case object R extends DeoxyribonucleotideUncertainty('R', Deoxyribonucleotides("AG"))

case object W extends DeoxyribonucleotideUncertainty('W', Deoxyribonucleotides("AT"))

case object S extends DeoxyribonucleotideUncertainty('S', Deoxyribonucleotides("CG"))

case object Y extends DeoxyribonucleotideUncertainty('Y', Deoxyribonucleotides("CT"))

case object K extends DeoxyribonucleotideUncertainty('K', Deoxyribonucleotides("GT"))

case object V extends DeoxyribonucleotideUncertainty('V', Deoxyribonucleotides("ACG"))

case object H extends DeoxyribonucleotideUncertainty('H', Deoxyribonucleotides("ACT"))

case object D extends DeoxyribonucleotideUncertainty('D', Deoxyribonucleotides("AGT"))

case object B extends DeoxyribonucleotideUncertainty('B', Deoxyribonucleotides("CGT"))

case object N extends DeoxyribonucleotideUncertainty('N', Deoxyribonucleotides("AG"))

case object X extends DeoxyribonucleotideUncertainty('X', Deoxyribonucleotide.seq)

object DeoxyribonucleotideUncertainty {
  val seq = Seq[DeoxyribonucleotideUncertainty](M, R, W, S, Y, K, V, H, D, B, N, X)
  private val map = seq.map(uncertainty => uncertainty.symbol -> uncertainty).toMap

  def apply(symbol: Char) = map(symbol)

  def get(symbol: Char) = map.get(symbol)
}
