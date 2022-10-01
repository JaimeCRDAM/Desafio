package Models.AModels

abstract class ASpecialty() {
    abstract val canAttend:ArrayList<String>
    abstract fun Attend()
    abstract fun AddCanAttend(provides:String)

}