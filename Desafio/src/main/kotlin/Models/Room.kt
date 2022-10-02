package Models

import Models.People.Patient

class Room {
    var capacity:Int = 20
    var patients:ArrayList<Patient> = ArrayList()









    fun GetAmountPatients():Int{
        return patients.size
    }

    fun PatientArrives(patient: Patient){
        patients.add(patient)
        patients.sortBy {
            it.priority
        }
    }

    fun PattientIsBeingAttended(): Patient? {
        if (patients.size > 1){
            return patients.removeAt(0)
        }
        return null
    }
}