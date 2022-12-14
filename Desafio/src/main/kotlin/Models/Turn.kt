package Models

import Models.AModels.ASpecialty
import Models.Factory.factoryMedic
import Models.People.Medic
import Models.People.Patient
import java.time.DayOfWeek

class Turn(val turnNumber:Int, turnDay:Int, private var specialties:Array<ASpecialty>, private val rooms:Array<Room>) {
    private val medics:ArrayList<Medic> = ArrayList()
    private val turnDay: DayOfWeek = DayOfWeek.of(turnDay)
    private val howManyDoctorsOfEach = 1
    private var attendedPatients:ArrayList<String> = ArrayList()
    private var movedPatients:ArrayList<String> = ArrayList()
    init {
        Increment()
        EnrollMedics()
    }
    companion object {
        var turnNumber = 0
        fun Increment(){
            turnNumber++
        }
    }


    fun TreatPatient(){
        val patient = ChoosePatient()?: return
        val medic = TreatmentAvailability(patient)
        if (medic == null){
            MovePatient(patient)
            return
        }
        val canAttend = CompanyCompatibility(patient, medic)
        if(canAttend){
            Treatment(patient, medic)
            return
        }
        MovePatient(patient)
    }

    private fun CompanyCompatibility(patient: Patient, medic: Medic):Boolean{
        return medic.ShareCompany(patient, medic)
    }

    private fun TreatmentAvailability(patient: Patient):Medic? {
        medics.forEach {medic ->
            var canMedicAttend = medic.specialty.CanAttendPatient(patient, medic)
            if(canMedicAttend != null){
                return canMedicAttend
            }
        }
        return null
    }

    private fun ChoosePatient(): Patient? {
        return MostFullRoom().PattientIsBeingAttended()
    }

    private fun MostFullRoom(): Room {
        var mostFullRoom:Room = rooms[0]
        rooms.forEach {
            if(mostFullRoom.GetAmountPatients() < it.GetAmountPatients()){
                mostFullRoom = it
            }
        }
        return mostFullRoom
    }

    private fun MovePatient(patient: Patient){
        val stringToAdd = "Patient ${patient.name} with NIDI ${patient.NIDI}, Insurance ${patient.insurance} attended on $turnDay with clear symptoms of ${patient.attention} could not be attended at Nebulon-B Frigate for lacking of staff/insurance"
        movedPatients.add(stringToAdd)

    }
    private fun Treatment(patient: Patient, medic: Medic){
        val stringToAdd = "Patient ${patient.name} with NIDI ${patient.NIDI}, Insurance ${patient.insurance} attended on $turnDay with clear symptoms of ${patient.attention} was attended at Nebulon-B Frigate by ${medic.name} with NIDI ${medic.NIDI}"
        attendedPatients.add(stringToAdd)
    }

    fun TurnRecap():Pair<ArrayList<String>,  ArrayList<String>>{
        return Pair(attendedPatients, movedPatients)
    }

    fun GetDay():DayOfWeek{
        return turnDay
    }

    private fun EnrollMedics(){
        var specialtySize = specialties.size
        var amount = specialtySize*howManyDoctorsOfEach
        (1..amount).forEach {i ->
            var specialty = specialties[i%specialtySize]
            medics.add(factoryMedic(specialty))
        }
    }

}