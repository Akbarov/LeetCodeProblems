package problems

import kotlin.math.sqrt

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(countPrimes2(499_999))
    println(countPrimes(0))
    println(countPrimes(1))
}

private fun countPrimes(n: Int): Int {

    if (n < 2) return 0
    val primes = mutableSetOf<Int>()
    primes.add(2)
    var count = 1
    outer@ for (i in 3 until n) {
        for (item in primes) {
            if (item > sqrt(i.toDouble())) {
                break
            }
            if (i % item == 0) {
                continue@outer
            }
        }
        primes.add(i)
        count++
    }
    return count
}

private fun countPrimes2(n: Int): Int {
    if (n <= 2) return 0
    val primeNumber = BooleanArray(n) { true }
    for (i in 2 until sqrt(n.toDouble()).toInt()) {
        if (primeNumber[i]) {
            val k = i.toLong()
            for (j in k*k until n step k) {
                primeNumber[j.toInt()] = false
            }
        }
    }
    var count = 0
    for (i in 2 until n) {
        if (primeNumber[i]) {
            count++
        }
    }
    return count
}