package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    print(countHomogenous("abbcccaaa"))
}

private fun countHomogenous(s: String): Int {
    var result = 0L
    val mod = 1_000_000_007
    var count = 0L
    for (i in s.indices) {
        if (i == 0 || s[i - 1] == s[i]) {
            count++
        } else {
            result = (result + ((count + 1) * count / 2) % mod) % mod
            count = 1
        }
    }
    result = (result + ((count + 1) * count / 2) % mod) % mod

    return result.toInt()
}