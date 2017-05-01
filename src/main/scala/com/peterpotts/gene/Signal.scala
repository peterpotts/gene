package com.peterpotts.gene

sealed trait Signal

case object Start extends Signal

sealed trait Stop extends Signal

case object Ochre extends Stop

case object Amber extends Stop

case object Opal extends Stop

object Stop {
  val list = List(Ochre, Amber, Opal)
  private val map = list.map(stop => stop.toString -> stop).toMap

  def apply(code: String): Stop = map(code)
}
