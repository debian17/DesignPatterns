package prototype

interface SheepPrototype {
    fun clone(): Sheep
}

class Sheep(var name: String) : SheepPrototype {
    override fun clone(): Sheep {
        return Sheep(name)
    }
}

