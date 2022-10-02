package Models.Specialties

import Models.AModels.ASpecialty

class Traumatologist : ASpecialty() {
    override var canAttend = ArrayList<String>()
    init {
        AddCanAttend("Quemadura láser")
    }

    override fun AddCanAttend(provides:String){
        canAttend.add(provides)
    }
}