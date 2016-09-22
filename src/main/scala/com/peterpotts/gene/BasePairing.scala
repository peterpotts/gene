package com.peterpotts.gene

object BasePairing {
  val deoxyribose = Map(Adenine -> Thymine, Cytosine -> Guanine, Guanine -> Cytosine, Thymine -> Adenine)
  val ribose = Map(Adenine -> Uracil, Cytosine -> Guanine, Guanine -> Cytosine, Uracil -> Adenine)
}
