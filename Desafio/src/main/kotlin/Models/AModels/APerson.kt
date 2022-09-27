package Models.AModels

abstract class APerson() {
    init {
        incrementar()
    }
    abstract var NIDI:String
    abstract var nombre:String
    companion object {
        var NIDIstatic = 0
        fun incrementar(){
            NIDIstatic++
        }
    }
}