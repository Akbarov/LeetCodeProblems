package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(nthSuperUglyNumber(12, intArrayOf(2, 7, 13, 19)))
}

private fun nthSuperUglyNumber(n: Int, primes: IntArray): Int {
    if (n == 1) return 1
    val set = mutableSetOf(1)
    var count = 1
    var i = 1
    while (count < n) {
        i++
        var currentNumber = i
        outer@ for (item in primes) {
            if (currentNumber < item) break
            while (currentNumber % item == 0) {
                currentNumber /= item
                if (currentNumber in set) {
                    set.add(i)
                    count++
                    break@outer
                }
            }
        }
    }
    return i
}