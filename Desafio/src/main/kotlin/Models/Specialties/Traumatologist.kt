package Models.Specialties

import Models.AModels.ASpecialty

class Traumatologist() : ASpecialty() {
    override lateinit var canAttend:ArrayList<String>
    init {
        AddCanAttend("Quemadura láser")
    }
    override fun Attend() {
        TODO("Not yet implemented")
    }

    override fun AddCanAttend(provides:String){
        canAttend.add(provides)
    }
}