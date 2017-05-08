package com.peterpotts.gene

sealed abstract class Deoxyribonucleosides(val symbol: Char, deoxyribonucleosides: List[Deoxyribonucleoside])

object Deoxyribonucleosides {

  case object M extends Deoxyribonucleosides('M', Deoxyribonucleosides("AC"))

  case object R extends Deoxyribonucleosides('R', Deoxyribonucleosides("AG"))

  case object W extends Deoxyribonucleosides('W', Deoxyribonucleosides("AT"))

  case object S extends Deoxyribonucleosides('S', Deoxyribonucleosides("CG"))

  case object Y extends Deoxyribonucleosides('Y', Deoxyribonucleosides("CT"))

  case object K extends Deoxyribonucleosides('K', Deoxyribonucleosides("GT"))

  case object V extends Deoxyribonucleosides('V', Deoxyribonucleosides("ACG"))

  case object H extends Deoxyribonucleosides('H', Deoxyribonucleosides("ACT"))

  case object D extends Deoxyribonucleosides('D', Deoxyribonucleosides("AGT"))

  case object B extends Deoxyribonucleosides('B', Deoxyribonucleosides("CGT"))

  case object N extends Deoxyribonucleosides('N', Deoxyribonucleoside.list)

  case object X extends Deoxyribonucleosides('X', Deoxyribonucleoside.list)

  val list: List[Deoxyribonucleosides] = List(M, R, W, S, Y, K, V, H, D, B, N, X)

  private val map = list.map(uncertainty => uncertainty.symbol -> uncertainty).toMap

  def apply(symbol: Char): Deoxyribonucleosides = map(symbol)

  def get(symbol: Char): Option[Deoxyribonucleosides] = map.get(symbol)

  def apply(symbols: String): List[Deoxyribonucleoside] = symbols.map(Deoxyribonucleoside(_)).toList
}
