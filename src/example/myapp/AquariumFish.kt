package example.myapp

abstract class AquariumFish: FishAction {
    abstract val color: String
    override fun eat() {
        println("НЯМ")
    }
}

class Shark: AquariumFish(), FishAction {
    override val color = "grey"
    override fun eat() {
        println("Акула выходит на охоту")
    }
}

class GoldenFish: AquariumFish(), FishAction {
    override val color = "gold"
    override fun eat() {
        println("Рыбка ест корм")
    }
}