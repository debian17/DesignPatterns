package structural.proxy

//SAMPLE #1
abstract class Operation {
    abstract fun execute()
}

class SimpleOperation : Operation() {
    override fun execute() {
        println("This is simple operation")
    }
}

abstract class OperationExecutor {
    abstract fun execute(operation: Operation)
}

class SimpleOperationExecutor : OperationExecutor() {
    override fun execute(operation: Operation) {
        operation.execute()
    }
}

abstract class ProxyOperationExecutor : OperationExecutor() {

    abstract fun beforeOperation()
    abstract fun afterOperation()

    override fun execute(operation: Operation) {
        beforeOperation()
        operation.execute()
        afterOperation()
    }

}

class SimpleProxyOperationExecutor : ProxyOperationExecutor() {
    override fun beforeOperation() {
        println("beforeOperation")
    }

    override fun afterOperation() {
        println("afterOperation")
    }
}

//SAMPLE #2
abstract class Warrior(val name: String)

abstract class WarriorTower {
    abstract fun enter(warrior: Warrior)
}

class ElfWarrior(name: String) : Warrior(name)

class ElfWarriorTower : WarriorTower() {
    override fun enter(warrior: Warrior) {
        println("Warrior name = ${warrior.name}")
    }
}

class ElfProxyTower(private val warriorTower: WarriorTower) : WarriorTower() {

    companion object {
        private const val WARRIOR_MAX_SIZE = 2
    }

    private var warriorCount = 0

    override fun enter(warrior: Warrior) {
        if (warriorCount < WARRIOR_MAX_SIZE) {
            warriorTower.enter(warrior)
            warriorCount++
        } else {
            println("The tower is full")
        }
    }
}