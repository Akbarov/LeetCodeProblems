package problems

import java.math.BigInteger

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(trailingZeroes(5))
    println(trailingZeroes(50))
    println(trailingZeroes(500))
}

private fun trailingZeroes(n: Int): Int {
  return if (n==0) 0 else n/5+ trailingZeroes(n/5)
}