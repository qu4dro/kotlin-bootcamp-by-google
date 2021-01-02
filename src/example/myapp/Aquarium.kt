package example.myapp

class Aquarium(var width: Int = 20, var height: Int = 40, var length: Int = 100) {
    //    var width: Int = width
    //    var height: Int = height
    //    var length: Int = length
    var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    constructor(numberOfFish: Int) : this() {
        val tank = numberOfFish * 2000 * 1.1
        height = (tank / (length * width)).toInt()
    }

//    init {
//        println("Инициализация аквариума")
//        println("Объем: ${width * length * height / 1000} литров")
//    }

    fun printSize() {
        println("Ширина: $width см \n" +
                "Высота: $height см \n" +
                "Длина: $length см")

        println("Объем: $volume л")
    }

}