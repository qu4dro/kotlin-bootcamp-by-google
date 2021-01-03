package example.myapp

fun buildAquarium() {

    // default height and length
    val aquarium1 = Aquarium()
    aquarium1.printSize()

    // default width
    val aquarium2 = Aquarium(height = 35, length = 60)
    aquarium2.printSize()

    // everything custom
    val aquarium3 = Aquarium(width = 25, height = 35, length = 110)
    aquarium3.printSize()

    //second constructor
    val aquarium4 = Aquarium(numberOfFish = 20)
    aquarium4.printSize()
    aquarium4.volume = 70
    aquarium4.printSize()

    val aquarium5 = Aquarium(length = 25, width = 25, height = 40)
    aquarium5.printSize()
    //println("Объем: ${aquarium4.width * aquarium4.length * aquarium4.height / 1000} литров (init второго конструктора) ")

    val roundAquarium1 = RoundAquarium(diameter = 25, height = 40)
    roundAquarium1.printSize()
}

fun main() {
    buildAquarium()
}