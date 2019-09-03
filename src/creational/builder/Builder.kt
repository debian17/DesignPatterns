package creational.builder

class SmartPhone private constructor(builder: Builder) {

    val vendor: String?
    val displaySize: Int
    val gps: Boolean

    init {
        vendor = builder.vendor
        displaySize = builder.displaySize
        gps = builder.gps
    }

    companion object Builder {
        private var vendor: String? = null
        private var displaySize = 0
        private var gps = false

        fun setVendor(vendor: String): Builder {
            this.vendor = vendor
            return this
        }

        fun setDisplaySize(displaySize: Int): Builder {
            this.displaySize = displaySize
            return this
        }

        fun setGPS(gps: Boolean): Builder {
            this.gps = gps
            return this
        }

        fun build(): SmartPhone {
            return SmartPhone(this)
        }

    }

}