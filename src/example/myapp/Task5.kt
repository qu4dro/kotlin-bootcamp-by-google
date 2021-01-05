package example.myapp

class Task5 {
}

fun main() {
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



}