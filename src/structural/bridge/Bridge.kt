package structural.bridge

abstract class Device {
    private var volume = 0
    fun setVolume(volume: Int) {
        this.volume = volume
    }

    fun getVolume(): Int {
        return volume
    }

    abstract fun getDescription(): String

}

class Tv : Device() {

    companion object {
        private const val DESCRIPTION = "This is TV"
    }

    override fun getDescription(): String {
        return DESCRIPTION
    }

}

class Radio : Device() {

    companion object {
        private const val DESCRIPTION = "This is Radio"
    }

    override fun getDescription(): String {
        return DESCRIPTION
    }

}

//Separate Device inheritance and Remote inheritance
abstract class Remote(protected val device: Device) {
    abstract fun volumeDown()
    abstract fun volumeUp()
    abstract fun getDeviceDescription(): String
}

class SimpleRemote(device: Device) : Remote(device) {

    override fun volumeDown() {
        device.setVolume(device.getVolume() - 10)
    }

    override fun volumeUp() {
        device.setVolume(device.getVolume() + 10)
    }

    override fun getDeviceDescription(): String {
        return device.getDescription()
    }

}

class AdvancedRemote(
    device: Device,
    private val percent: Int
) : Remote(device) {

    override fun volumeDown() {
        device.setVolume(device.getVolume() - percent)
    }

    override fun volumeUp() {
        device.setVolume(device.getVolume() + percent)
    }

    override fun getDeviceDescription(): String {
        return device.getDescription()
    }

    //addition method
    fun mute() {
        device.setVolume(0)
    }

}