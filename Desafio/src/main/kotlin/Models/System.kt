package Models

import Models.AModels.ASpecialty
import Models.Factory.turnFactory
import Models.Factory.factorySoldier
import Models.People.Patient
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.stream.Collectors

class System {
    val roomsAmount = 3
    val rooms:Array<Room> = Array(roomsAmount){Room()}
    lateinit var currentTurn:Turn
    lateinit var turnInfo:String
    var turnStart:Int = 0
    var turnEnd:Int = 0
    var turnDuration = 10
    var turns:Int = 3




    fun Simulacion(){
        var time = 0
        var Days = 7
        var totalSimTime = 7*30
        StartTurn(1)
        while (time < totalSimTime){
            if (time%2 == 0){
                var patient = PatientArrives()
                var leastFullRoom = LeastFullRoom(rooms)
                leastFullRoom.PatientArrives(patient)
            }
            if(time%4 == 0){
                currentTurn.TreatPatient()
            }



            time++
            //Thread.sleep(1000)
        }
    }

    fun LeastFullRoom(rooms:Array<Room>):Room{
        var leastFull: Room? = null
        rooms.map {
            if (leastFull == null){
                leastFull = it
            }
            if(leastFull!!.GetAmountPatients() > it.GetAmountPatients()){
                leastFull = it
            }
        }
        return leastFull!!
    }
    fun PatientArrives():Patient{
        return factorySoldier()
    }
    private fun StartTurn(dayOfWeek:Int){
        var specialties = AvailableSpecialties()
        currentTurn = turnFactory(turnStart, turnEnd, dayOfWeek, specialties, rooms)
    }
    fun AvailableSpecialties():Array<ASpecialty>{
        lateinit var availableSpecialties:Array<ASpecialty>
        var si = FindAllClassesUsingClassLoader("Models.Specialties")
        availableSpecialties = Array(si.size){
            si.toList().get(it)?.getDeclaredConstructor()?.newInstance() as ASpecialty
        }
        return availableSpecialties
    }
    private fun FindAllClassesUsingClassLoader(packageName: String): Set<Class<*>?> {//God Bless Reflection
        val stream = ClassLoader.getSystemClassLoader()
            .getResourceAsStream(packageName.replace("[.]".toRegex(), "/"))
        val reader = BufferedReader(InputStreamReader(stream))
        return reader.lines()
            .filter { line: String -> line.endsWith(".class") }
            .map { line: String -> GetClass(line, packageName) }
            .collect(Collectors.toSet())
    }
    private fun GetClass(className: String, packageName: String): Class<*>? {
        try {
            return Class.forName(
                packageName + "."
                        + className.substring(0, className.lastIndexOf('.'))
            )
        } catch (e: ClassNotFoundException) {
            // handle the exception
        }
        return null
    }
}