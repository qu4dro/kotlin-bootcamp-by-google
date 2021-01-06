package generics

fun genericExample() {
    val aquarium = Aquarium<TapWater>(TapWater())
    val aquarium2 = Aquarium(LakeWater())
    //aquarium2.addWater()
    aquarium2.waterSupply.filter()
    aquarium2.addWater()
//    val aquarium2 = Aquarium("string")
//    println(aquarium2.waterSupply)
//    val aquarium3 = Aquarium(null)
//    if (aquarium3.waterSupply == null) {
//        println("null")
//    }
    //aquarium.waterSupply.addChemicalCleaners()
    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")
    aquarium.waterSupply.addChemicalCleaners()
    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")
}

open class WaterSupply(var needsProcessing: Boolean) {

}

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() {
        needsProcessing = false
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessing = false
    }
}

class Aquarium<T : WaterSupply>(val waterSupply: T) {
    fun addWater() {
        check(!waterSupply.needsProcessing) { "water supply needs processing first" }
        println("adding water from $waterSupply")
    }
}

fun main() {
    genericExample()
}