package structural.composite

//SAMPLE #1

abstract class Shape {
    abstract fun move(x: Int, y: Int)
    abstract fun draw()
}

class Circle(val x: Int, val y: Int, val radius: Int) : Shape() {
    override fun move(x: Int, y: Int) {
        println("Move circle to $x,$y")
    }

    override fun draw() {
        println("Draw circle x=$x,y=$y, radius=$radius")
    }
}

class Line(val x1: Int, val y1: Int, val x2: Int, val y2: Int) : Shape() {
    override fun move(x: Int, y: Int) {
        println("Move circle to $x,$y")
    }

    override fun draw() {
        println("Draw line from x1=$x1,y1=$y2 to x2=$x2,y2=$y2")
    }
}

class ShapeComposite : Shape() {

    private val shapes = ArrayList<Shape>()

    override fun move(x: Int, y: Int) {
        shapes.forEach {
            it.move(x, y)
        }
    }

    override fun draw() {
        shapes.forEach {
            it.draw()
        }
    }

    fun add(shape: Shape) {
        shapes.add(shape)
    }
}
