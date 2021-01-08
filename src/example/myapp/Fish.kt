package example.myapp


data class Fish(var name: String) {
}

val fish2 = Fish(name = "fish").apply { name = "new name" }

//inline myWith(fish2.name) {
//
//}

fun fishExamples() {
    val fish = Fish("splashy")
    myWith(fish.name) {
        println(this.capitalize())
        println(this.replace(this, "QwErTy"))
    }

}

inline fun myWith(name: String, block: String.() -> Unit) {
    name.block()

}

fun main() {
    fishExamples()
    println(fish2.name)
    println(fish2.let { it.name.capitalize() }.let { it + "123" }.let { it.length }.let { it + 21 })
}

