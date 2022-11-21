package problems

import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(binaryGap(22))
}

private fun binaryGap(n: Int): Int {

    var result = 0
    var hasOne = false
    var count = 1
    var temp = n
    while (temp != 0) {
        if (temp and 1 == 1) {
            if (hasOne) {
                result = max(result, count)
            }
            hasOne = true
            count = 1
        } else {
            count++
        }
        temp = temp shr 1
    }
    return result
}