package com.example.perturbators

trait Perturbable[T] {
  def perturbate(value: T): T
}
