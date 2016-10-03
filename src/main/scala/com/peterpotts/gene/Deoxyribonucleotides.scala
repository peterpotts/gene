package com.peterpotts.gene

import scala.collection.immutable.Seq

sealed abstract class Deoxyribonucleotides(val symbol: Char, deoxyribonucleotides: Seq[Deoxyribonucleotide])

object Deoxyribonucleotides {

  case object M extends Deoxyribonucleotides('M', Deoxyribonucleotides("AC"))

  case object R extends Deoxyribonucleotides('R', Deoxyribonucleotides("AG"))

  case object W extends Deoxyribonucleotides('W', Deoxyribonucleotides("AT"))

  case object S extends Deoxyribonucleotides('S', Deoxyribonucleotides("CG"))

  case object Y extends Deoxyribonucleotides('Y', Deoxyribonucleotides("CT"))

  case object K extends Deoxyribonucleotides('K', Deoxyribonucleotides("GT"))

  case object V extends Deoxyribonucleotides('V', Deoxyribonucleotides("ACG"))

  case object H extends Deoxyribonucleotides('H', Deoxyribonucleotides("ACT"))

  case object D extends Deoxyribonucleotides('D', Deoxyribonucleotides("AGT"))

  case object B extends Deoxyribonucleotides('B', Deoxyribonucleotides("CGT"))

  case object N extends Deoxyribonucleotides('N', Deoxyribonucleotide.seq)

  case object X extends Deoxyribonucleotides('X', Deoxyribonucleotide.seq)

  val seq = Seq[Deoxyribonucleotides](M, R, W, S, Y, K, V, H, D, B, N, X)

  private val map = seq.map(uncertainty => uncertainty.symbol -> uncertainty).toMap

  def apply(symbol: Char) = map(symbol)

  def get(symbol: Char) = map.get(symbol)

  def apply(symbols: String): Seq[Deoxyribonucleotide] = symbols.map(Deoxyribonucleotide(_))
}
