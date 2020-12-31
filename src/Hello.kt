import kotlin.random.Random

fun main(args: Array<String>) {
//    val isUnit = println("Expression")
    //println(isUnit)

    val temperature = 10
    val isHot = temperature > 50
    //println(isHot)

    val message = "The water temperature is ${if (temperature > 50) "too warm" else "OK"}."
    //println(message)
    feedTheFish()
    swim()
    swim("медленно")
    swim(speed = "очень быстро")
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
