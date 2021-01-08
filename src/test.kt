import java.util.*


fun main() {
    val scanner = Scanner(System.`in`)
    val list = mutableListOf<Int>()
    while (true) {
        list.add(scanner.nextInt())
        if (list.size == 5) break
    }

    println(taskAnswer(list))
}

fun taskAnswer(list: List<Int>): Boolean {
    val number = list[4]
    return (number >= list[0] && number <= list[1]) || (number >= list[2] && number <= list[3])
}

fun getVolume(length: Int = 1, width: Int = 1, height: Int = 1): Int {
    return width * height * length
}
//    val f: Float = 20.0f + 20.02f // 1
//    val l: Long = 10 + 2L        // 2
//    val n: Int = l.toInt() + 5           // 3
//    val str = "Hello" + '2'


//fun listBuilder(string: String): List<String> {
//    list.add(string.split(" "))
//}