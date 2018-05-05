package com.example.perturbators.primitives

import com.example.perturbators.Perturbable
import com.example.tools.ActionTools

object StringPerturbator extends ActionTools with Perturbable[String] {
  def perturbate(value: String): String = {
    val aPosition = nextInt(value.size) match {
      case i if i >= 0 && i < value.size => i
      case i@_ => i - 1
    }
    AddRemoveAction.randomAction match {
      case SingleAction.ADD =>
        value.take(aPosition) + nextChar() + value.takeRight(value.size - aPosition)
      case SingleAction.REMOVE =>
        value.take(aPosition) + value.takeRight(value.size - aPosition - 1)
    }
  }
}
