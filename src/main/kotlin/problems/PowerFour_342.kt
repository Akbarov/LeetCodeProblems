package problems

import kotlin.math.log
import kotlin.math.pow

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(isPowerOfFour(16))
}
private fun isPowerOfFour(n: Int): Boolean {
   val x = log(n.toDouble(), 4.0).toInt()
    return 4.0.pow(x.toDouble()).toInt()==n
}