package com.peterpotts.gene

import scala.collection.immutable.Seq

sealed trait Signal

case object Start extends Signal

sealed trait Stop extends Signal

case object Ochre extends Stop

case object Amber extends Stop

case object Opal extends Stop

object Stop {
  val seq = Seq(Ochre, Amber, Opal)

  private val map = seq.map(stop => stop.toString -> stop).toMap

  def apply(code: String) = map(code)
}
