package com.example.tools

import scala.collection.GenTraversableOnce

/**
  * Position randomizer
  */
trait GenPosition extends Random{
  protected def generatePosition(value: GenTraversableOnce[_]): Int =
    nextInt(value.size) match {
      case i if i >= 0 && i < value.size => i
      case i@_ => i - 1
    }
}
