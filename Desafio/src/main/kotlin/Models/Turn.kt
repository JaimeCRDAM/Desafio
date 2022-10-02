package Models

import Models.AModels.ASpecialty
import Models.Factory.factoryMedic
import Models.People.Medic
import Models.People.Patient
import java.time.DayOfWeek
import java.util.stream.Collectors

class Turn(val turnNumber:Int, turnDay:Int, var specialties:Array<ASpecialty>, val rooms:Array<Room>) {
    init {
        Increment()
    }
    companion object {
        var turnNumber = 0
        fun Increment(){
            turnNumber++
        }
    }
    val turnDay = DayOfWeek.of(turnDay)
    val medics:Array<Medic> = Array(specialties.size){
        factoryMedic(specialties[it])
    }
    var attendedPatients:ArrayList<String> = ArrayList()
    var movedPatients:ArrayList<String> = ArrayList()

    fun TreatPatient(){
        var patient = ChoosePatient()
        var medic = patient?.let { TreatmentAvailability(it) }
        if (medic != null){
            var canAttend = CompanyCompatibility(patient!!, medic)
            if(canAttend){
                Treatment(patient, medic)
                return
            }
            MovePatient(patient)
            return
        }
        if(patient != null){
            MovePatient(patient)
        }
    }

    fun CompanyCompatibility(patient: Patient, medic: Medic):Boolean{
        if (patient != null){
            medic.company.map { medicCompany ->
                if(medicCompany == patient.insurance){
                    return true
                }
            }
        }
        return false
    }

    fun TreatmentAvailability(patient: Patient):Medic? {
        medics.map {medic ->
            medic.specialty.canAttend.map { provides ->
                if (patient.attention == provides){
                    return medic
                }
            }
        }
        return null
    }

    fun ChoosePatient():Patient?{
        var patient:Patient? = MostFullRoom().PattientIsBeingAttended()
        if (patient != null){
            return patient
        }
        return null
    }

    fun MostFullRoom():Room{
        var mostFullRoom: Room? = null
        rooms.map {
            if (mostFullRoom == null){
                mostFullRoom = it
            }
            if(mostFullRoom!!.GetAmountPatients() < it.GetAmountPatients()){
                mostFullRoom = it
            }
        }
        return mostFullRoom!!
    }

    fun MovePatient(patient: Patient){
        val stringToAdd = "Patient ${patient.name} with NIDI ${patient.NIDI}, Insurance ${patient.insurance} attended on ${turnDay} with clear symptoms of ${patient.attention} could not be attended at Nebulon-B Frigate for lacking of staff/insurance"
        movedPatients.add(stringToAdd)

    }
    fun Treatment(patient: Patient, medic: Medic){
        val stringToAdd = "Patient ${patient.name} with NIDI ${patient.NIDI}, Insurance ${patient.insurance} attended on ${turnDay} with clear symptoms of ${patient.attention} was attended at Nebulon-B Frigate by ${medic.name} with NIDI ${medic.NIDI}"
        attendedPatients.add(stringToAdd)
    }

    fun TurnRecap():Pair<ArrayList<String>,  ArrayList<String>>{
        return Pair(attendedPatients, movedPatients)
    }

    fun GetDay():DayOfWeek{
        return turnDay
    }

}