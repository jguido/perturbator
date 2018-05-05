package com.example.tools

import scala.collection.immutable.NumericRange
import scala.util.{Random => ScalaRandom}

trait Random {

  private val chars: NumericRange.Inclusive[Char] = 'A' to 'z'

  def nextInt(bound: Int): Int = ScalaRandom.nextInt(bound + 1)
  def nextPercent(bound: Int): Double = ScalaRandom.nextInt(bound + 1).toDouble / 100

  def nextChar(): Char = chars(nextInt(chars.length-1))
}
