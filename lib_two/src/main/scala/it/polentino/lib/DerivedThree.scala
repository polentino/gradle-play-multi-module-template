package it.polentino.lib

class DerivedThree extends DerivedOne {
  override def getString: String = "from DerivedThree > " + super.getString
}
