import creational.abstract_factory.*
import creational.builder.SmartPhone
import creational.factory_method.*
import creational.object_pool.ExpensiveObjectPool
import creational.prototype.Sheep
import structural.adapter.Captain
import structural.adapter.FishingAdapter
import structural.adapter.FishingBoat
import structural.bridge.*
import structural.decorator.ShieldWarrior
import structural.decorator.SimpleWarrior
import structural.decorator.SwordWarrior
import structural.decorator.Warrior
import structural.facade.SystemFacade

fun main() {

    //Generative
    //printFactoryMethodExample()
    //printAbstractFactoryExample()
    //printBuilderExample()
    //printPrototypeExample()
    //printObjectPoolExample()

    //Structural
    //printDecoratorExample()
    //printAdapterExample()
    //printBridgeExample()
    //printFacadeExample()

}

//Generative
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

//Structural
fun printDecoratorExample() {
    val simpleWarrior: Warrior = SimpleWarrior()
    println("Simple warrior power = ${simpleWarrior.getWarriorPower()}")

    //add sword decoration to simple warrior
    val swordWarrior: Warrior = SwordWarrior(simpleWarrior)
    println("Sword warrior power = ${swordWarrior.getWarriorPower()}")

    //add shield decoration to simple warrior
    val shieldWarrior: Warrior = ShieldWarrior(simpleWarrior)
    println("Shield warrior power = ${shieldWarrior.getWarriorPower()}")

    //add sword and shield decoration to simple warrior
    val megaWarrior: Warrior = ShieldWarrior(SwordWarrior(simpleWarrior))
    println("Mega warrior power = ${megaWarrior.getWarriorPower()}")

}

fun printAdapterExample() {
    val fishingBoat = FishingBoat()

    val fishingAdapter = FishingAdapter(fishingBoat)

    val captain = Captain(fishingAdapter)

    captain.move()

}

fun printBridgeExample() {

    val tv = Tv()
    val radio = Radio()

    val simpleRemote = SimpleRemote(tv)

    val advancedRemote = AdvancedRemote(radio, 1)

    simpleRemote.volumeUp()

    advancedRemote.mute()

}

fun printFacadeExample() {

    val systemFacade = SystemFacade()

    systemFacade.start()

    systemFacade.stop()

}