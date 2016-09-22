package com.peterpotts.gene

object StandardGeneticCode extends Translation {
  val data = Map(
    "UUU" -> "Phe",
    "UUC" -> "Phe",
    "UUA" -> "Leu",
    "UUG" -> "Leu",

    "UCU" -> "Ser",
    "UCC" -> "Ser",
    "UCA" -> "Ser",
    "UCG" -> "Ser",

    "UAU" -> "Tyr",
    "UAC" -> "Tyr",
    "UAA" -> "Ochre",
    "UAG" -> "Amber",

    "UGU" -> "Cys",
    "UGC" -> "Cys",
    "UGA" -> "Opal",
    "UGG" -> "Trp",

    "CUU" -> "Leu",
    "CUC" -> "Leu",
    "CUA" -> "Leu",
    "CUG" -> "Leu",

    "CCU" -> "Pro",
    "CCC" -> "Pro",
    "CCA" -> "Pro",
    "CCG" -> "Pro",

    "CAU" -> "His",
    "CAC" -> "His",
    "CAA" -> "Gln",
    "CAG" -> "Gln",

    "CGU" -> "Arg",
    "CGC" -> "Arg",
    "CGA" -> "Arg",
    "CGG" -> "Arg",

    "AUU" -> "Ile",
    "AUC" -> "Ile",
    "AUA" -> "Ile",
    "AUG" -> "Met",

    "ACU" -> "Thr",
    "ACC" -> "Thr",
    "ACA" -> "Thr",
    "ACG" -> "Thr",

    "AAU" -> "Asn",
    "AAC" -> "Asn",
    "AAA" -> "Lys",
    "AAG" -> "Lys",

    "AGU" -> "Ser",
    "AGC" -> "Ser",
    "AGA" -> "Arg",
    "AGG" -> "Arg",

    "GUU" -> "Val",
    "GUC" -> "Val",
    "GUA" -> "Val",
    "GUG" -> "Val",

    "GCU" -> "Ala",
    "GCC" -> "Ala",
    "GCA" -> "Ala",
    "GCG" -> "Ala",

    "GAU" -> "Asp",
    "GAC" -> "Asp",
    "GAA" -> "Glu",
    "GAG" -> "Glu",

    "GGU" -> "Gly",
    "GGC" -> "Gly",
    "GGA" -> "Gly",
    "GGG" -> "Gly")

  private val map = data.map {
    case (key, value) =>
      RNACodon(key) -> AminoAcid.get(value).map(Right(_)).getOrElse(Left(Stop(value)))
  }

  def apply(codon: Codon): Either[Signal, AminoAcid] = map(codon)
}