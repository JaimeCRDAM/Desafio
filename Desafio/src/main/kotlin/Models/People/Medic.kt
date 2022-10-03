package Models.People
import Models.AModels.APerson
import Models.AModels.ASpecialty
import Models.IModels.IMedic

class Medic(override var NIDI: String, override var name: String, var specialty:ASpecialty, var company:Array<String>):APerson(),
    IMedic {
}