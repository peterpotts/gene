package com.peterpotts.gene

sealed abstract class Deoxyribonucleotides(val symbol: Char, deoxyribonucleotides: List[Deoxyribonucleoside])

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

  case object N extends Deoxyribonucleotides('N', Deoxyribonucleotide.list)

  case object X extends Deoxyribonucleotides('X', Deoxyribonucleotide.list)

  val list: List[Deoxyribonucleotides] = List(M, R, W, S, Y, K, V, H, D, B, N, X)

  private val map = list.map(uncertainty => uncertainty.symbol -> uncertainty).toMap

  def apply(symbol: Char): Deoxyribonucleotides = map(symbol)

  def get(symbol: Char): Option[Deoxyribonucleotides] = map.get(symbol)

  def apply(symbols: String): List[Deoxyribonucleoside] = symbols.map(Deoxyribonucleotide(_)).toList
}
