package com.peterpotts.gene

import scala.collection.immutable.IndexedSeq

trait Enumeration[T <: Enumerated] extends Serializable {
  val indexedSeq: IndexedSeq[T]

  private lazy val map: Map[String, T] = indexedSeq.map(enumerated => enumerated.id -> enumerated).toMap

  def valueOf(key: String): Option[T] = map.get(key)
}
