package example.myapp


open class Aquarium(open var width: Int = 20, open var height: Int = 40, open var length: Int = 100) {
    //    var width: Int = width
    //    var height: Int = height
    //    var length: Int = length
    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open val shape = "rectangle"
    open var water: Double = 0.0
        get() = volume * 0.9

    constructor(numberOfFish: Int) : this() {
        val tank = numberOfFish * 2000 * 1.1
        height = (tank / (length * width)).toInt()
    }

//    init {
//        println("Инициализация аквариума")
//        println("Объем: ${width * length * height / 1000} литров")
//    }

    fun printSize() {
        println("Ширина: $width см " +
                "Высота: $height см " +
                "Длина: $length см")

        println("Объем: $volume л Вода: $water л (${water / volume * 100.0}%)")
    }

}
