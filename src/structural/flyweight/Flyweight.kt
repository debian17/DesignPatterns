package structural.flyweight

//BAD EXAMPLE
//We need to create over9000 box with same x,y,z, but with different material and we want optimize memory usage
class BadBox(val x: Int, val y: Int, val z: Int, material: String) {
    init {
        println("Create bad box: x=$x, y=$y, z=$z")
    }
}

//SOLUTION
class Size(val x: Int, val y: Int, val z: Int) {
    init {
        println("Create size: x=$x, y=$y, z=$z")
    }
}

class Box(val id: Int, val size: Size, val material: String) {
    init {
        println("Create box: x=${size.x}, y=${size.y}, z=${size.z}")
    }
}

class SizeFactory {

    companion object {
        private val sizes = ArrayList<Size>()
        fun getBoxSize(x: Int, y: Int, z: Int): Size {
            var size = sizes.find { it.x == x && it.y == y && it.z == z }
            if (size == null) {
                size = Size(x, y, z)
                sizes.add(size)
            }
            return size
        }
    }

}



