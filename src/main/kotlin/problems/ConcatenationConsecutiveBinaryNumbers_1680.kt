package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(concatenatedBinary(1))
println(concatenatedBinary(3))
println(concatenatedBinary(12))
}

private fun concatenatedBinary(n: Int): Int {
    val mod = 1_000_000_007
    var length = 0
    var sum = 0L
    for (i in 1..n) {
        if(i and (i-1)==0)length++
        sum = ((sum shl length) or i.toLong())%mod
    }
    return sum.toInt()
}