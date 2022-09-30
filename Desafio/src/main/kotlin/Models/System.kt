package Models

import Models.AModels.ASpecialty
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.stream.Collectors

class System {
    var turnStart:Int = 0
    var turnEnd:Int = 0
    var turnDuration = 10
    var turns:Int = 3
    lateinit var currentTurn:Turn
    val rooms:Array<Room> = Array(3){Room()}

    fun docs():Array<ASpecialty>{
        lateinit var medicsAtCall:Array<ASpecialty>
        var si = findAllClassesUsingClassLoader("Models.Specialties")
        medicsAtCall = Array(si.size){
            si.toList().get(it)?.getDeclaredConstructor()?.newInstance() as ASpecialty
        }
        return medicsAtCall
    }
    private fun findAllClassesUsingClassLoader(packageName: String): Set<Class<*>?> {//God Bless Reflection
        val stream = ClassLoader.getSystemClassLoader()
            .getResourceAsStream(packageName.replace("[.]".toRegex(), "/"))
        val reader = BufferedReader(InputStreamReader(stream))
        return reader.lines()
            .filter { line: String -> line.endsWith(".class") }
            .map { line: String -> getClass(line, packageName) }
            .collect(Collectors.toSet())
    }
    private fun getClass(className: String, packageName: String): Class<*>? {
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