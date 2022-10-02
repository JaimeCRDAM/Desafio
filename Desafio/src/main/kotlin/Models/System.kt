package Models

import Models.AModels.ASpecialty
import Models.Factory.turnFactory
import Models.Factory.factorySoldier
import Models.People.Patient
import java.io.BufferedReader
import java.io.InputStreamReader
import java.time.DayOfWeek
import java.util.stream.Collectors
import kotlin.math.floor

class System {
    private val roomsAmount = 3
    private val rooms:Array<Room> = Array(roomsAmount){Room()}
    private var time = 1
    private val turnsPerDay = 3
    private val turnTime = 10
    private val Days = 7
    private val totalSimTime = Days*turnsPerDay*turnTime+1
    private val DayOfWeek = GetCurrentDay(1, turnsPerDay*turnTime)
    private val availableSpecialties = AvailableSpecialties()
    private var currentTurn:Turn = StartTurn(DayOfWeek,availableSpecialties)
    init {
        Simulation()
    }




    private fun Simulation(){
        while (time < totalSimTime){
            if (time%2 == 0){
                PatientArrives()
            }
            if(time%4 == 0){
                currentTurn.TreatPatient()
            }
            if(time%10 == 0){
                currentTurn = RecapAndStartTurn()
            }
            time++
            //Thread.sleep(1000)
        }
    }

    private fun LeastFullRoom(rooms:Array<Room>):Room{
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
    private fun PatientArrives(){
        val leastFullRoom = LeastFullRoom(rooms)
        leastFullRoom.PatientArrives(factorySoldier())
    }
    private fun StartTurn(dayOfWeek:Int, availableSpecialties:Array<ASpecialty>):Turn{
        return turnFactory(dayOfWeek, availableSpecialties, rooms)
    }
    private fun AvailableSpecialties():Array<ASpecialty>{
        lateinit var availableSpecialties:Array<ASpecialty>
        val si = FindAllClassesUsingClassLoader("Models.Specialties").toList()
        availableSpecialties = Array(si.size){
            si[it].getDeclaredConstructor().newInstance() as ASpecialty
        }
        return availableSpecialties
    }
    private fun FindAllClassesUsingClassLoader(packageName: String): Set<Class<*>> {//God Bless Reflection
        val stream = ClassLoader.getSystemClassLoader()
            .getResourceAsStream(packageName.replace("[.]".toRegex(), "/"))
        val reader = BufferedReader(InputStreamReader(stream))
        return reader.lines()
            .filter { line: String -> line.endsWith(".class") }
            .map { line: String -> GetClass(line, packageName) }
            .collect(Collectors.toSet())
    }
    private fun GetClass(className: String, packageName: String): Class<*> {
        return Class.forName(
            packageName + "."
                    + className.substring(0, className.lastIndexOf('.'))
        )
    }
    private fun GetCurrentDay(time:Int, totalTurnTime:Int):Int{
        val dayNumber:Int = floor((time / totalTurnTime).toDouble()).toInt()
        if (dayNumber == 7)
            return 7
        return dayNumber+1
    }
    private fun TurnRecapToString(pair:Pair<ArrayList<String>, ArrayList<String>>, day:DayOfWeek, turnTime:Int){
        val arrayOfTimes = arrayOf("00:00-08:00", "08:00-16:00", "16:00-00:00")
        println("\n$day turn range: ${arrayOfTimes[turnTime%3]}")
        println("Treated patients:")
        pair.first.map {
            println(it)
        }
        println("Moved patients:")
        pair.second.map {
            println(it)
        }
    }
    private fun RecapAndStartTurn():Turn{
        val DayOfWeek = GetCurrentDay(time, turnsPerDay*turnTime)
        TurnRecapToString(currentTurn.TurnRecap(), currentTurn.GetDay(), currentTurn.turnNumber)
        return StartTurn(DayOfWeek, availableSpecialties)
    }
}