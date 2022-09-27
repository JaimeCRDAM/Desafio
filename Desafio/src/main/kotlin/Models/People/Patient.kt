package Models.People

import Models.AModels.APerson

class Patient(override var NIDI: String, override var nombre: String, var seguro:String, var atencion:String, var prioridad:Int) : APerson() {

}