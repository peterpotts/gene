package com.peterpotts.gene

sealed trait Decoding

/**
  * The enzyme RNA polymerase catalyzes the synthesis of a messenger RNA from an expressed protein-coding gene of the
  * DNA.
  */
trait Transcription extends Decoding

/**
  * Messenger RNA to protein.
  */
trait Translation extends Decoding