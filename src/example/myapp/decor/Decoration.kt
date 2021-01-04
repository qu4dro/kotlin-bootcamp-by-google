package example.myapp.decor

data class Decoration(val rocks: String) {

}

data class Decoration2(val rock: String, val wood: String, val diver: String) {

}

enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF)
}

enum class Direction(val degrees: Int) {
    NORTH(0), SOUTH(180), EAST(90), WEST(270)
}

fun makeDecorations() {
    val decoration1 = Decoration("granite")
    println(decoration1)

    val decoration2 = Decoration("slate")
    println(decoration2)

    val decoration3 = Decoration("slate")
    println(decoration3)

    println(decoration2.equals(decoration1))
    println(decoration2.equals(decoration3))

    val decor1 = Decoration2("crystal", "wood", "diver")
    println(decor1)

    val (rock, wood, diver) = decor1
    println(rock)
    println(wood)
    println(diver)

    val (rock2, _, diver2) = decor1

}


fun main() {
    makeDecorations()
    println(Direction.EAST.degrees)
    println(Direction.EAST.name)
    println(Direction.EAST.ordinal)
}