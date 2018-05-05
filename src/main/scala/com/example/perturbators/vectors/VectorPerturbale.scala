package com.example.perturbators.vectors

import com.example.perturbators.Perturbable
import com.example.tools.{ActionTools, GenPosition}

/**
  *
  * @tparam T has to be part of GenTraversableOnce
  */
trait VectorPerturbable[T] extends ActionTools with GenPosition  with Perturbable[Vector[T]]{
  def applyPerturbationOn(value: T): T

  def perturbate(value: Vector[T]): Vector[T] = {
    if (value.isEmpty) {
      value
    } else {
      val aPosition = generatePosition(value)

      AddRemoveAction.randomAction match {
        case SingleAction.ADD =>
          val current: T = value(aPosition)
          (value.take(aPosition) :+ applyPerturbationOn(current)) ++ value.takeRight(value.length - aPosition)
        case SingleAction.REMOVE =>
          value.take(aPosition) ++ value.takeRight(value.length - aPosition - 1)
      }
    }
  }
}
