package problems

import kotlin.math.log

fun main() {
    println(isPowerOfThree(27))
    println(isPowerOfThree2(27))
    println(isPowerOfThree2(27))
    println(isPowerOfThree2(29))
}

private fun isPowerOfThree(n: Int): Boolean {
    var temp = n
    while (temp > 1 && temp % 3 == 0) {
        temp /= 3
    }
    return temp == 1
}

private fun isPowerOfThree2(n: Int): Boolean {
    return if (n == 1) true
    else if (n < 1) false
    else if (n % 3 != 0) false
    else isPowerOfThree2(n / 3)
}