package Models.Specialties

import Models.AModels.ASpecialty
import Models.People.Patient

class Traumatologist : ASpecialty() {
    override var canAttend: ArrayList<String> = ArrayList(1)
    init {
        AddCanAttend("Quemadura láser")
    }

    override fun AddCanAttend(provides:String){
        canAttend.add(provides)
    }
}