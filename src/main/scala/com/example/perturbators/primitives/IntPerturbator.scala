package com.example.perturbators.primitives

import com.example.perturbators.Perturbable
import com.example.tools.ActionTools

object IntPerturbator extends ActionTools with Perturbable[Int] {
  def perturbate(value: Int): Int =
    AddRemoveAction.randomAction match {
      case SingleAction.ADD => value + (value.toDouble * nextPercent(10)).toInt
      case SingleAction.REMOVE => value - (value.toDouble * nextPercent(10)).toInt
    }
}
