package com.example

import com.example.model.Person
import com.example.perturbators.model.PersonPerturbator
import com.example.perturbators.primitives.{IntPerturbator, StringPerturbator}
import com.example.perturbators.vectors.{IntVectorPerturbator, StringVectorPerturbator}

trait PerturbatorImplicit {


  implicit class ImplicitIntPerturbator(val value: Int) {
    def perturbate: Int = IntPerturbator.perturbate(value)
  }

  implicit class ImplicitStringPerturbator(val value: String) {
    def perturbate: String = StringPerturbator.perturbate(value)
  }

  implicit class ImplicitPersonPerturbator(val value: Person) {
    def perturbate: Person = PersonPerturbator.perturbate(value)
  }

  implicit class ImplicitVectorStringPerturbator(val value: Vector[String]) {
    def perturbate = StringVectorPerturbator.perturbate(value)
  }

  implicit class ImplicitVectorIntPerturbator(val value: Vector[Int]) {
    def perturbate = IntVectorPerturbator.perturbate(value)
  }

}
