package Models.Specialties

import Models.AModels.ASpecialty

class Internist() : ASpecialty() {
    override var canAttend = ArrayList<String>()
    init {
        AddCanAttend("Impacto chorritrónico")
    }
    override fun AddCanAttend(provides:String){
        canAttend.add(provides)
    }
}