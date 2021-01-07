package generics

fun genericExample() {
    val aquarium = Aquarium<TapWater>(TapWater())
    val cleaner = TapWaterCleaner()
    val aquarium2 = Aquarium(LakeWater())
    //aquarium2.addWater()
    aquarium2.waterSupply.filter()
    aquarium.addWater(cleaner)
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

    addItemTo(aquarium)
    isWaterClean(aquarium)
    println(aquarium.hasWaterSupplyOfType<TapWater>())
    println(aquarium.waterSupply.isOfType<TapWater>())
}

open class WaterSupply(var needsProcessing: Boolean) {

}

class TapWater() : WaterSupply(true) {
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
    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needsProcessing) {
            cleaner.clean(waterSupply)
        }
        println("water added")
//        check(!waterSupply.needsProcessing) { "water supply needs processing first" }
//        println("adding water from $waterSupply")

    }


}

fun <T : WaterSupply> addItemTo(aquarium: Aquarium<T>) = println("item added")

fun <T : WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println("aquarium water is clean: ${!aquarium.waterSupply.needsProcessing}")
}

fun main() {
    genericExample()
}

interface Cleaner<in T : WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner : Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}

inline fun <reified T : WaterSupply> WaterSupply.isOfType() = this is T

inline fun <reified R : WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R