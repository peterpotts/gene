package com.peterpotts.gene

/**
  * A protein chain has a primary structure formed by a sequence of amino acids.
  * The secondary structure is the generic structures formed by parts of the protein chain.
  * The tertiary structure is formed by further folding into a conformation unique to the protein chain.
  *
  * @param primaryStructure Sequence of amino acids.
  */
case class ProteinChain(primaryStructure: List[AminoAcid])

object ProteinChain {
  def apply(symbols: String): ProteinChain = ProteinChain(symbols.toStream.map(AminoAcid(_)).toList)
}

/**
  * Most proteins contain a single protein chain.
  * Some proteins contain multiple protein chains.
  * In which case,
  * the protein is known as a multiSubunit protein,
  * the protein chains are known as protein subunits and
  * the subunit composition is known as the quaternary conformation.
  *
  * @param proteinChains Some proteins contain multiple protein chains.
  */
case class Protein(proteinChains: List[ProteinChain])
