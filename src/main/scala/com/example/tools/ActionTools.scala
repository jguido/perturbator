package com.example.tools

trait ActionTools extends Random {

  object SingleAction extends Enumeration {
    type Action = Value
    val ADD, REMOVE = Value
  }

  type StaticAction = SingleAction.Value

  sealed trait Action{
    protected val actions: List[StaticAction]
    def randomAction: SingleAction.Value = actions(nextInt(actions.length-1))
  }

  case object AddRemoveAction extends Action {
    override protected val actions: List[StaticAction] =
      List(SingleAction.ADD, SingleAction.REMOVE)
  }
}
