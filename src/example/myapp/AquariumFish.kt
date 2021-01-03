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
