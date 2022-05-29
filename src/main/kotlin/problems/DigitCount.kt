package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(digitCount("1210"))
println(digitCount("030"))
}

private fun digitCount(num: String): Boolean {
    val digit = IntArray(10)
    for (c in num) {
        digit[c - '0']++
    }
    for ((i, c) in num.withIndex()) {
        if (digit[i]!=(c-'0')){
            return false
        }
    }
    return true
}