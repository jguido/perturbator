package com.example.perturbators

import com.example.model.Person
import com.example.perturbators.model.PersonPerturbator
import com.example.perturbators.primitives.{IntPerturbator, StringPerturbator}

package object vectors {
  object StringVectorPerturbator extends VectorPerturbable[String] {
    override def applyPerturbationOn(value: String): String = StringPerturbator.perturbate(value)
  }

  object IntVectorPerturbator extends VectorPerturbable[Int] {
    override def applyPerturbationOn(value: Int): Int = IntPerturbator.perturbate(value)
  }

  object PersonVectorPerturbator extends VectorPerturbable[Person] {
    override def applyPerturbationOn(value: Person): Person = PersonPerturbator.perturbate(value)
  }
}
