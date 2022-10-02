package Models.People

import Models.AModels.APerson

class Patient(override var NIDI: String, override var name: String, var insurance:String, var attention:String, var priority:Int) : APerson()