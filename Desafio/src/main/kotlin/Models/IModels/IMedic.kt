package Models.IModels

import Models.People.Medic
import Models.People.Patient

interface IMedic {
    fun ShareCompany(patient:Patient, medic: Medic):Boolean{
        return medic.company.contains(patient.insurance)
    }
}