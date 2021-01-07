class FunctionalManipulation {
}

data class Fish(val name: String)

val waterFilter = { dirty: Int -> dirty / 2 }
val myFish = listOf(Fish("Gold"), Fish("Shark"), Fish(("Dory")))



fun main() {
    println(waterFilter(30))
    println(myFish.filter { it.name.contains('o') }.joinToString(", ") { it.name })
}