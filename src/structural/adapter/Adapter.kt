package structural.adapter

abstract class WarriorSheep {
    abstract fun move()
}

class FishingBoat {
    fun sail() {
        println("Fishing sheep is sail")
    }
}

class Captain(private val warriorSheep: WarriorSheep) {

    fun move() {
        warriorSheep.move()
    }

}

//Now Captain can move on fishing boat
class FishingAdapter(private val fishingBoat: FishingBoat) : WarriorSheep() {

    override fun move() {
        fishingBoat.sail()
    }

}


