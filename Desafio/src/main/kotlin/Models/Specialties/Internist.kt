package Models.Specialties

import Models.AModels.ASpecialty
import Models.People.Patient
import java.util.Arrays

class Internist : ASpecialty() {
    override var canAttend: ArrayList<String> = ArrayList(1)
    init {
        AddCanAttend("Impacto chorritrónico")
    }
    override fun AddCanAttend(provides:String){
        canAttend.add(provides)
    }
}