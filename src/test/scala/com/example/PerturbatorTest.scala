package com.example

import com.example.model.Person
import org.scalatest.{FlatSpec, Matchers}

class PerturbatorTest extends FlatSpec
  with Matchers
  with PerturbatorImplicit {

  behavior of "Perburbator"

  it should "perturbate an int" in {
    (100 to 500).foreach(v => {
      val perturbate = v.perturbate
      perturbate should (be >= (v - (v * 0.1)).toInt and be <= (v + (v * 0.1)).toInt)
    })
  }

  it should "perturbate a string" in {
    val strings = List("scala", "javascript", "go", "docker", "jenkins", "spark", "data")
    strings.foreach(v => {
      val perturbate = v.perturbate
      perturbate shouldNot equal(v)
    })
  }

  it should "perturbate a vector of string" in {
    (1 to 10).foreach(i => {
      val v = Vector("scala", "javascript", "go", "docker", "jenkins", "spark", "data")
      val b = v.perturbate
      b shouldNot equal(v)
    })

  }

  it should "perturbate a vector of int" in {
    (1 to 10).foreach(i => {
      val v = (100 to 500).toVector
      v.perturbate shouldNot equal(v)
    })
  }

  it should "perturbate a class of type Person with no parent" in {
    val pauline = Person("Paul", 25, Vector())
    val jacqueline = Person("Jacques", 28, Vector())
    val paul = Person("Paul", 25, Vector())
    val jacques = Person("Jacques", 28, Vector())

    val perturbatedPauline = pauline.perturbate
    val perturbatedJacqueline = jacqueline.perturbate
    val perturbatedPaul = paul.perturbate
    val perturbatedJacques = jacques.perturbate

    val testData = List(
      (pauline, perturbatedPauline),
      (jacqueline, perturbatedJacqueline),
      (paul, perturbatedPaul),
      (jacques, perturbatedJacques)
    )

    testData.foreach(d => {
      d._2.name shouldNot equal(d._1.name)
      d._2.age should(be >= (d._1.age - (d._1.age * 0.1)).toInt and be <= (d._1.age + (d._1.age * 0.1)).toInt)
      d._2.parents.size should(be < 2 or be > 2)
    })
  }

  it should "perturbate a class of type Person" in {
    val paul = Person("Paul", 25, Vector())
    val pauline = Person("Paul", 25, Vector())

    val jacques = Person("Jacques", 28, Vector())
    val jacqueline = Person("Jacques", 28, Vector())

    val paul1 = Person("Paul", 25, Vector(paul, pauline))
    val pauline1 = Person("Paul", 25, Vector(jacques, jacqueline))


    val pierre = Person("Pierre", 23, Vector(paul1, pauline1))

    (1 to 5).foreach(_ => {
      val p = pierre.perturbate
      p.name shouldNot equal(pierre.name)
      p.age should(be >= (pierre.age - (pierre.age * 0.1)).toInt and be <= (pierre.age + (pierre.age * 0.1)).toInt)
      p.parents.size should(be < 2 or be > 2)
    })
  }

}
