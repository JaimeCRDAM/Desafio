package Models.AModels

abstract class APerson {
    init {
        increment()
    }
    abstract var NIDI:String
    abstract var name:String
    companion object {
        var NIDIStatic = 0
        fun increment(){
            NIDIStatic++
        }
    }
}