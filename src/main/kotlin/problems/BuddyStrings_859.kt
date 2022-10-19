package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(buddyStrings("ab", "ab"))
    println(buddyStrings("ab", "ba"))
    println(buddyStrings("aa", "aa"))
}

private fun buddyStrings(s: String, goal: String): Boolean {
    if (s.length < 2) return false
    if (s.length != goal.length) return false
    if (s == goal) {
        return s.toSet().size != s.length
    } else {
        for (i in s.indices) {
            if (s[i] != goal[i]) {
                for (j in i + 1 until s.length) {
                    if (s[j] != goal[j]) {
                        val array = s.toCharArray()
                        array[i] = s[j]
                        array[j] = s[i]
                        return array.joinToString("") == goal
                    }
                }
            }
        }
    }
    return false

}