package structural.facade

//Inheritance from base class\interface is not necessary
abstract class System {
    abstract fun operation1()
    abstract fun operation2()
}

class LightSystem : System() {
    override fun operation1() {
        println("Light system operation 1")
    }

    override fun operation2() {
        println("Light system operation 1")
    }

}

class VideoSystem : System() {

    override fun operation1() {
        println("Video system operation 1")
    }

    override fun operation2() {
        println("Video system operation 2")
    }

}

class SoundSystem : System() {
    override fun operation1() {
        println("Sound system operation 1")
    }

    override fun operation2() {
        println("Sound system operation 2")
    }

}

class SystemFacade {
    private val lightSystem = LightSystem()
    private val videoSystem = VideoSystem()
    private val soundSystem = SoundSystem()

    fun start() {
        lightSystem.operation1()
        videoSystem.operation1()
        soundSystem.operation1()
    }

    fun stop() {
        lightSystem.operation2()
        videoSystem.operation2()
        soundSystem.operation2()
    }

}

