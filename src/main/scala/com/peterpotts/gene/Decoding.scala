package com.peterpotts.gene

sealed trait Decoding

/**
  * The enzyme RNA polymerase catalyzes the synthesis of a messenger RNA from an expressed protein-coding gene of the
  * DNA.
  */
trait Transcription extends Decoding

/**
  * Messenger RNA is translated into protein by ribosomes according to the genetic code.
  */
trait Translation extends Decoding {
  def apply(codon: Codon): Either[Signal, AminoAcid]
}