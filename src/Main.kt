import abstract_factory.*
import builder.SmartPhone
import factory_method.*
import object_pool.ExpensiveObjectPool
import prototype.Sheep

fun main() {

    //printFactoryMethodExample()
    //printAbstractFactoryExample()
    //printBuilderExample()
    //printPrototypeExample()
    //printObjectPoolExample()

}

fun printFactoryMethodExample() {
    var blacksmith: Blacksmith
    var axe: Weapon
    var spear: Weapon

    blacksmith = HumanBlacksmith()
    axe = blacksmith.makeWeapon(WeaponType.AXE)
    spear = blacksmith.makeWeapon(WeaponType.SPEAR)
    println(axe.getDescription())
    println(spear.getDescription())
    println()

    blacksmith = ElfBlacksmith()
    axe = blacksmith.makeWeapon(WeaponType.AXE)
    spear = blacksmith.makeWeapon(WeaponType.SPEAR)
    println(axe.getDescription())
    println(spear.getDescription())
    println()

    blacksmith = OrcBlacksmith()
    axe = blacksmith.makeWeapon(WeaponType.AXE)
    spear = blacksmith.makeWeapon(WeaponType.SPEAR)
    println(axe.getDescription())
    println(spear.getDescription())
}

fun printAbstractFactoryExample() {
    var king: King
    var castle: Castle
    var army: Army
    var factory: KingdomFactory

    factory = HumanKingdomFactory()
    king = factory.createKing("Anduin")
    castle = factory.createCastle("Stormwind")
    army = factory.createArmy()
    println(king.getDescription())
    println(castle.getDescription())
    println(army.getDescription())
    println()

    factory = ElfKingdomFactory()
    king = factory.createKing("Thranduil")
    castle = factory.createCastle("Mirkwood")
    army = factory.createArmy()
    println(king.getDescription())
    println(castle.getDescription())
    println(army.getDescription())
    println()

    factory = OrcKingdomFactory()
    king = factory.createKing("Thrall")
    castle = factory.createCastle("Orgrimmar")
    army = factory.createArmy()
    println(king.getDescription())
    println(castle.getDescription())
    println(army.getDescription())
    println()

}

fun printBuilderExample() {

    val smartPhone = SmartPhone
        .setVendor("Samsung")
        .setDisplaySize(5)
        .setGPS(true)
        .build()

    println(smartPhone.vendor)
    println(smartPhone.displaySize)
    println(smartPhone.gps)

}

fun printPrototypeExample() {
    val original = Sheep("Smashing")
    val newSheep = original.clone()
    newSheep.name = "Black Pearl"
    println(newSheep.name)
}

fun printObjectPoolExample() {

    val pool = ExpensiveObjectPool(2)

    val obj1 = pool.getFromPool()
    val obj2 = pool.getFromPool()

    //will be null
    val obj3 = pool.getFromPool()

    //return objects
    if (obj1 != null) {
        pool.returnToPool(obj1)
    }
    if (obj2 != null) {
        pool.returnToPool(obj2)
    }

    Thread {
        val obj4 = pool.getFromPool()
    }.start()

    Thread.sleep(100L)

    val obj6 = pool.getFromPool()

    if (obj6 != null) {
        println(obj6.id)
    }

}