package example.myapp

//abstract class AquariumFish: FishAction {
//    abstract val color: String
//    override fun eat() {
//        println("НЯМ")
//    }
//}

interface FishColor {
    val color: String
}

interface FishAction {
    fun eat()
}

object GoldColor : FishColor {
    override val color = "gold"
}

class Shark : FishAction, FishColor {
    override val color = "grey"
    override fun eat() {
        println("Акула выходит на охоту")
    }
}

//A sealed class is a class that can be subclassed, but only inside the file in which it's declared.
sealed class Seal
class SeaLion : Seal()
class Walrus : Seal()

fun matchSeal(seal : Seal): String {
    return when (seal) {
        is Walrus -> "walrus"
        is SeaLion -> "sealion"
    }
}


class GoldenFish(fishColor: FishColor = GoldColor) : FishAction by PrintingFishAction("Еда"), FishColor by fishColor {
    //override val color = "gold"
//    override fun eat() {
//        println("Рыбка ест корм")
//    }
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}
