package abstract_factory

//Base classes
abstract class King(protected val name: String) {
    abstract fun getDescription(): String
}

abstract class Castle(protected val name: String) {
    abstract fun getDescription(): String
}

abstract class Army {
    abstract fun getDescription(): String
}

//Impl King class
class HumanKing(name: String) : King(name) {
    override fun getDescription(): String {
        return "$name is the Human king"
    }
}

class ElfKing(name: String) : King(name) {
    override fun getDescription(): String {
        return "$name is the Elf king"
    }
}

class OrcKing(name: String) : King(name) {
    override fun getDescription(): String {
        return "$name is the Orc king"
    }
}

//Impl Castle class
class HumanCastle(name: String) : Castle(name) {
    override fun getDescription(): String {
        return "This is the Human castle $name"
    }
}

class ElfCastle(name: String) : Castle(name) {
    override fun getDescription(): String {
        return "This is the Elf castle $name"
    }
}

class OrcCastle(name: String) : Castle(name) {
    override fun getDescription(): String {
        return "This is the Orc castle $name"
    }
}

class HumanArmy : Army() {
    override fun getDescription(): String {
        return "This is the Human army"
    }
}

class ElfArmy : Army() {
    override fun getDescription(): String {
        return "This is the Elf army"
    }
}

class OrcArmy : Army() {
    override fun getDescription(): String {
        return "This is the Orc army"
    }
}

//Abstract Factory
abstract class KingdomFactory() {
    abstract fun createKing(name: String): King
    abstract fun createCastle(name: String): Castle
    abstract fun createArmy(): Army
}

class HumanKingdomFactory : KingdomFactory() {
    override fun createKing(name: String): King {
        return HumanKing(name)
    }

    override fun createCastle(name: String): Castle {
        return HumanCastle(name)
    }

    override fun createArmy(): Army {
        return HumanArmy()
    }
}

class ElfKingdomFactory : KingdomFactory() {
    override fun createKing(name: String): King {
        return ElfKing(name)
    }

    override fun createCastle(name: String): Castle {
        return ElfCastle(name)
    }

    override fun createArmy(): Army {
        return ElfArmy()
    }

}

class OrcKingdomFactory : KingdomFactory() {
    override fun createKing(name: String): King {
        return OrcKing(name)
    }

    override fun createCastle(name: String): Castle {
        return OrcCastle(name)
    }

    override fun createArmy(): Army {
        return OrcArmy()
    }
}

