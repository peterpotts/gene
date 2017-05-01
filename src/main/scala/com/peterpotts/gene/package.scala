package com.peterpotts

package object gene {
  type Nucleoside = Nucleobase with Sugar
  type Deoxyribonucleoside = Nucleobase with Deoxyribose
  type Ribonucleoside = Nucleobase with Ribose
}
