package example.myapp

const val rocks = 3

object Constants {
    const val CONST = "const"
}

class Task5 {
    companion object {
        const val COMP_CONST = "comp_const"
    }
}

fun main() {
    val rocks1 = Constants.CONST
    val list = mutableListOf<Int>()
    for (i in 1..99) {
        list.add(i)
    }
    println(list.sum())

    val list2 = listOf("Java", "Kotlin", "Dart")
    println(list2.sumBy { it.length })

    for (element in list2) {
        println(element)
    }

    for (element in list2.listIterator()) {
        println(element)
    }

    val cures = hashMapOf("white spots" to "Ich", "red sores" to "hole disease")
    println(cures.get("white spots"))
    println(cures["red sores"])
    println(cures["Ich"])
    println(cures.getOrDefault("Ich", "no key"))
    println(cures.getOrElse("Ich") { "no key" })

    val inventory = mutableMapOf("fish net" to 1)
    inventory.put("tank scrubber", 3)
    println(inventory)
    println(inventory.toString())
    inventory.remove("fish net")
    println(inventory.toString())

    println("Тут есть пробелы?".hasSpaces())
    println("Тут?".hasSpaces())

    val aquariumPlant = AquariumPlant("green", 20)
    val aquariumPlant2: AquariumPlant? = null
    aquariumPlant2.pull()
    aquariumPlant.pull()

    println(aquariumPlant.isGreen)
}

//fun String.hasSpaces(): Boolean {
//    val found = this.find { it == ' ' }
//    return found != null
//}

fun String.hasSpaces(): Boolean = find { it == ' ' } != null

open class AquariumPlant(val color: String, private val size: Int)

class GreenLeafyPlant(size: Int) : AquariumPlant("green", size)

val AquariumPlant.isGreen: Boolean
    get() = color == "green"

fun AquariumPlant?.pull() {
    this?.apply { println("$this") }
}