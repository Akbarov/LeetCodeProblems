package problems

import java.util.Stack
import kotlin.math.abs

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun asteroidCollision(asteroids: IntArray): IntArray {
    var index = 0
    val result = IntArray(asteroids.size)
    label@ for (item in asteroids)  {
        if (item > 0) {
            result[index++] = item
        } else {
            while (index >= 0 && result[index] > 0) {
                if (result[index] > abs(item)) {
                    continue@label
                } else if (result[index] == abs(item)) {
                    index--
                    continue@label
                } else {
                    index--
                }
            }
            result[index++] = item
        }
    }
    if (index<=0)return intArrayOf()
    return result.copyOfRange(0, index)
}