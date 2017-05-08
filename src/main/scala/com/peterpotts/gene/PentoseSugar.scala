package com.peterpotts.gene

/**
  * The five-carbon sugar ring found in nucleotides.
  *
  * @author Peter Potts
  */
sealed trait PentoseSugar

/**
  * Five-carbon sugar ring without hydroxyl group found in DNA.
  */
trait Deoxyribose extends PentoseSugar

/**
  * Five-carbon sugar ring with hydroxyl group found in RNA.
  */
trait Ribose extends PentoseSugar
