package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(repeatedSubstringPattern("ababab"))
}

private fun repeatedSubstringPattern(s: String): Boolean {
    for (i in s.length / 2 downTo 1) {
        if (s.length % i == 0) {
            val m = s.length / i
            val sub = s.substring(0, i)
            val sb = StringBuilder()
            for (j in 0 until m) {
                sb.append(sub)
            }
            if (sb.toString() == s) return true
        }
    }
    return false
}