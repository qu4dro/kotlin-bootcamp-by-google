import kotlin.random.Random

val decorations = listOf("Камень", "Замок", "Дерево", "Солдатик", "Цветок")


fun main(args: Array<String>) {
//    val isUnit = println("Expression")
    //println(isUnit)
    val decorations = listOf("Камень", "Замок", "Дерево", "Солдатик", "Цветок", "Кактус")
    val temperature = 10
    val isHot = temperature > 50
    //println(isHot)

    val message = "The water temperature is ${if (temperature > 50) "too warm" else "OK"}."
    //println(message)
    feedTheFish()
    swim()
    swim("медленно")
    swim(speed = "очень быстро")

    // eager, creates a new list
    val eager = decorations.filter { it[0] == 'К' }

    // lazy, will wait until asked to evaluate
    val filtered = decorations.asSequence().filter { it[0] == 'К' }

    // force evaluation of the lazy list
    val newList = filtered.toList()

    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }

    val lazyMap2 = decorations.asSequence().filter { it[0] == 'К' }.map {
        println("access: $it")
        it
    }

    println("eager: $eager")
    println("filtered: $filtered")
    println("newList: $newList")

    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")
    println("-----")
    println("filtered: ${lazyMap2.toList()}")
    //println(decorations.filter { it[0] == 'К' })
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Сегодня $day и рыба ест $food")
    println("Поменять воду ${shouldChangeWater(day)}")
}

fun randomDay(): String {
    val week = arrayOf("Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресение")
    return week[Random.nextInt(week.size)]
}

fun fishFood(day: String): String {
    return when (day) {
        "Понедельник" -> "корм"
        "Вторник" -> "червячки"
        "Среда" -> "гранулы"
        "Четверг" -> "планктон"
        "Пятница" -> "крупа"
        else -> "nothing"
    }
}

fun swim(speed: String = "быстро") {
    println("Скорость $speed")
}

fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isTooDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 30

fun isTooDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Понедельник"
