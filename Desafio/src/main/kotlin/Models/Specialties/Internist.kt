package Models.Specialties

import Models.AModels.ASpecialty

class Internist() : ASpecialty() {
    override lateinit var canAttend:ArrayList<String>
    init {
        AddCanAttend("Impacto chorritrónico")
    }
    override fun Attend() {
        TODO("Not yet implemented")
    }
    override fun AddCanAttend(provides:String){
        canAttend.add(provides)
    }
}