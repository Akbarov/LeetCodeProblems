package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(countBinarySubstrings("00110011"))
    println(countBinarySubstrings2("10101"))
}

//O(n^2)
private fun countBinarySubstrings(s: String): Int {
    var count = 0
    for ((i, c) in s.withIndex()) {
        var temp = 1
        var j = i + 1
        while (j < s.length && s[j] == c) {
            temp++
            j++
        }
        while (j < s.length && s[j] != c && temp > 0) {
            temp--
            j++
        }
        if (temp == 0) count++

    }
    return count
}

//O(n)
private fun countBinarySubstrings2(s: String): Int {
    var current = 1
    var prev = 0
    var ans = 0
    for (i in 1 until s.length) {
        if (s[i] == s[i - 1]) {
            current++
        } else {
            prev = current
            current = 1
        }
        if (prev >= current) ans++
    }
    return ans
}