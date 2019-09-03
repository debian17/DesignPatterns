package structural.decorator

abstract class Warrior {
    abstract fun getWarriorPower(): Int
}

class SimpleWarrior : Warrior() {

    companion object {
        private const val SIMPLE_WARRIOR_POWER = 10
    }

    override fun getWarriorPower(): Int {
        return SIMPLE_WARRIOR_POWER
    }

}

//We can't inherit from SimpleWarrior, but we can decorate it
abstract class WarriorDecorator(private val warrior: Warrior) : Warrior() {

    override fun getWarriorPower(): Int {
        return warrior.getWarriorPower()
    }

}

class SwordWarrior(warrior: Warrior) : WarriorDecorator(warrior) {

    companion object {
        private const val SWORD_WARRIOR_POWER = 15
    }

    override fun getWarriorPower(): Int {
        return super.getWarriorPower() + SWORD_WARRIOR_POWER
    }

}

class ShieldWarrior(warrior: Warrior) : WarriorDecorator(warrior) {

    companion object {
        private const val SHIELD_WARRIOR_POWER = 7
    }

    override fun getWarriorPower(): Int {
        return super.getWarriorPower() + SHIELD_WARRIOR_POWER
    }

}

