package factory_method

enum class WeaponType {
    AXE,
    SPEAR
}

abstract class Weapon(val weaponType: WeaponType) {
    abstract fun getDescription(): String
}

class HumanWeapon(weaponType: WeaponType) : Weapon(weaponType) {
    override fun getDescription(): String {
        return "This is Human weapon=$weaponType"
    }
}

class ElfWeapon(weaponType: WeaponType) : Weapon(weaponType) {
    override fun getDescription(): String {
        return "This is Elf weapon=$weaponType"
    }
}

class OrcWeapon(weaponType: WeaponType) : Weapon(weaponType) {
    override fun getDescription(): String {
        return "This is Orc weapon=$weaponType"
    }
}

interface Blacksmith {
    fun makeWeapon(weaponType: WeaponType): Weapon
}

class HumanBlacksmith : Blacksmith {
    override fun makeWeapon(weaponType: WeaponType): Weapon {
        return HumanWeapon(weaponType)
    }
}

class ElfBlacksmith : Blacksmith {
    override fun makeWeapon(weaponType: WeaponType): Weapon {
        return ElfWeapon(weaponType)
    }
}

class OrcBlacksmith : Blacksmith {
    override fun makeWeapon(weaponType: WeaponType): Weapon {
        return OrcWeapon(weaponType)
    }
}