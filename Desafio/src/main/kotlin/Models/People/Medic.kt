package Models.People
import Models.AModels.APerson
import Models.AModels.ASpecialty

class Medic(override var NIDI: String, override var name: String, var specialty:ASpecialty, var company:Array<String>):APerson() {
}