package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(isPerfectSquare(16))
    println(isPerfectSquare(81))
    println(isPerfectSquare2(2_147_483_647))
}

private fun isPerfectSquare(num: Int): Boolean {

    if (num == 1) return true
    if (num < 4) return false
    var count = 2
    while (count * count <= num) {
        if (count * count == num) {
            return true
        }
        count++
    }
    return false
}

private fun isPerfectSquare2(num: Int): Boolean {
    var l = 0L
    var r = num.toLong()
    val numLong = num.toLong()
    var mid: Long
    while (l <= r) {
        mid = (l + r) / 2
        val sqr = mid * mid
        if (sqr == numLong) {
            return true
        } else if (sqr > num) {
            r = mid - 1
        } else {
            l = mid + 1
        }
    }
    return false
}