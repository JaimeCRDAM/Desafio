package Models.People
import Models.AModels.APerson
import Models.AModels.ASpecialty

class Medic(override var NIDI: String, override var nombre: String, var specialty:ASpecialty):APerson() {
}