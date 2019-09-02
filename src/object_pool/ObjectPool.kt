package object_pool

import java.lang.RuntimeException
import java.util.*
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.locks.ReentrantLock

abstract class ObjectPool<T>(private val poolSize: Int) {

    init {
        if (poolSize <= 0) {
            throw RuntimeException("Poll size can not be <= 0!")
        }
    }

    private val lock = ReentrantLock()
    private val objects = LinkedList<T>()
    private var inUse = 0

    abstract fun create(): T

    fun getFromPool(): T? {
        lock.lock()
        try {
            if (objects.isEmpty()) {
                if (inUse < poolSize) {
                    val instance = create()
                    inUse++
                    return instance
                } else {
                    return null
                }
            } else {
                inUse++
                return objects.removeLast()
            }
        } finally {
            lock.unlock()
        }
    }

    fun getFromPool(delay: Long, unit: TimeUnit): T? {
        val state = lock.tryLock(delay, unit)
        if (state) {
            try {
                return getFromPool()
            } finally {
                lock.unlock()
            }
        } else {
            return null
        }
    }

    fun returnToPool(instance: T): Boolean {
        lock.lock()
        try {
            if (inUse > 0) {
                objects.add(instance)
                inUse--
                return true
            }
            return false
        } finally {
            lock.unlock()
        }
    }

}

class ExpensiveObject {
    companion object {
        private val atomicInteger = AtomicInteger(0)
    }

    val id = atomicInteger.getAndIncrement()

    init {
        Thread.sleep(2000L)
    }
}

class ExpensiveObjectPool(poolSize: Int) : ObjectPool<ExpensiveObject>(poolSize) {
    override fun create(): ExpensiveObject {
        return ExpensiveObject()
    }
}