package com.peterpotts.gene

import scala.collection.immutable.Seq

case class Codon(
  first: Nucleotide,
  second: Nucleotide,
  third: Nucleotide) {
  val toSeq = Seq(first, second, third)
}

object Codon {
  def apply(sequence: String) = {
    Codon(
      first = Nucleotide(sequence.charAt(0)),
      second = Nucleotide(sequence.charAt(1)),
      third = Nucleotide(sequence.charAt(2)))
  }
}

/**
  * Alanine Ala/A	GCT, GCC, GCA, GCG
  * Arginine Arg/R	CGT, CGC, CGA, CGG, AGA, AGG
  * Asparagine Asn/N	AAT, AAC
  * Aspartic acid Asp/D	GAT, GAC
  * Cysteine Cys/C	TGT, TGC
  * Glutamine Gln/Q	CAA, CAG
  * Glutamic acid Glu/E	GAA, GAG
  * Glycine Gly/G	GGT, GGC, GGA, GGG
  * Histidine His/H	CAT, CAC
  * Isoleucine Ile/I	ATT, ATC, ATA
  * START	ATG
  * Leucine Leu/L	TTA, TTG, CTT, CTC, CTA, CTG
  * Lysine Lys/K	AAA, AAG
  * Methionine Met/M	ATG
  * Phenylalanine Phe/F	TTT, TTC
  * Proline Pro/P	CCT, CCC, CCA, CCG
  * Serine Ser/S	TCT, TCC, TCA, TCG, AGT, AGC
  * Threonine Thr/T	ACT, ACC, ACA, ACG
  * Tryptophan Trp/W	TGG
  * Tyrosine Tyr/Y	TAT, TAC
  * Valine Val/V	GTT, GTC, GTA, GTG
  * STOP	TAA, TGA, TAG (Ochre, Opal, Amber)
  */