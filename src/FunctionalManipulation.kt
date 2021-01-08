import example.JavaRun

class FunctionalManipulation {
}

data class Fish(val name: String)

val waterFilter = { dirty: Int -> dirty / 2 }
val myFish = listOf(Fish("Gold"), Fish("Shark"), Fish(("Dory")))

//fun runExample() {
//    val runnable = object : Runnable {
//        override fun run() {
//            println("I'm a Runnable")
//        }
//    }
//    JavaRun.runNow(runnable)
//}
//fun runExample() {
//    val runnable = Runnable { println("I'm a Runnable") }
//    JavaRun.runNow(runnable)
//}

fun runExample() {
    JavaRun.runNow {
        println("Passing a lambda as a Runnable")
    }
}

fun main() {
    println(waterFilter(30))
    println(myFish.filter { it.name.contains('o') }.joinToString(", ") { it.name })
    runExample()
}