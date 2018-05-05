package com.example.perturbators.model

import com.example.PerturbatorImplicit
import com.example.model.Person
import com.example.perturbators.Perturbable
import com.example.perturbators.vectors.PersonVectorPerturbator
import com.example.tools.ActionTools

object PersonPerturbator extends ActionTools with PerturbatorImplicit with Perturbable[Person]{

  def perturbate(value: Person): Person = {
    val parents = value.parents
    val name = value.name
    val age = value.age
    Person(name.perturbate, age.perturbate, PersonVectorPerturbator.perturbate(parents))
  }
}
