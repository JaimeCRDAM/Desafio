package Models

import Models.AModels.APerson
import Models.AModels.ASpecialty
import Models.People.*
import java.util.Random

object Factory {

    private var medicArray = arrayOf("Prewb Abias", "Yurka Aggel", "Ahleazah", "Aidarro", "Ake", "Akimbo", "Aloor", "Annowiskri", "Antona", "Ara", "Aboo Aramflahad", "Archimar", "Arljack", "Arnth", "Lilit Arranda", "Arrizza", "Asha-Mu", "Asirr")
    private var soldiersArray = arrayOf( "Scout Troopers", "Snow Troopers", "Space Troopers", "Stormtrooper Grenadiers", "Tank Troopers", "TD-110", "TD-4445", "TD-787", "Wanton")
    private var insuranceArray = arrayOf("Sanitroopers", "Vaderslas", "Yodacare")
    private var atenttionArray = arrayOf("Quemadura láser", "Impacto chorritrónico", "Otros")

    fun factoryMedic(specialty:ASpecialty):Medic{
        var NIDI =APerson.NIDIstatic.toString()
        var name = medicArray[Random().nextInt(0, medicArray.size)]
        var company = Array<String>(2){""}
        for (i in 0..1){
            var insurance = insuranceArray[Random().nextInt(0, insuranceArray.size)]
            company[i] = insurance
            while (company[0] == insurance){
                company[i] = insurance
            }
        }
        return Medic(NIDI, name, specialty, company)
    }

    fun factorySoldier():Patient{
        var NIDI =APerson.NIDIstatic.toString()
        var name = soldiersArray[Random().nextInt(0, soldiersArray.size)]
        var insurance = insuranceArray[Random().nextInt(0, insuranceArray.size)]
        var attention = atenttionArray[Random().nextInt(0, atenttionArray.size)]
        return Patient(NIDI, name, insurance, attention, Random().nextInt(1, 4))
    }

    fun turnFactory(turnStart:Int, turnEnd:Int, specialties:Array<ASpecialty>):Turn{

        return Turn(turnStart, turnEnd, specialties)
    }
}