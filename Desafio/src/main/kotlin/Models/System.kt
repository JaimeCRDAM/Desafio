package Models

class System {
    var turns:Int = 3
    lateinit var currentTurn:Turn
    val rooms:Array<Room> = Array(3){Room()}
}