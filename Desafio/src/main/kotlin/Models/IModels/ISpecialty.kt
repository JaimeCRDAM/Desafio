package Models.IModels

import Models.People.Medic
import Models.People.Patient

interface ISpecialty {
    var canAttend:ArrayList<String>

    fun AddCanAttend(provides:String){
        canAttend.add(provides)
    }

    fun CanAttendPatient(patient:Patient, medic: Medic):Medic?{
        if (medic.specialty.canAttend.contains(patient.attention)) return medic
        return null
    }
}