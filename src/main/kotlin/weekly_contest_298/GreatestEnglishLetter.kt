package weekly_contest_298

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(solution("AbCdEfGhIjK"))
    println(solution("arRAzFif"))
}

private fun solution(s: String): String {
    val set = s.toHashSet()
    val letters = IntArray(26)
    for (c in set) {
        if (c in 'a'..'z') {
            letters[c - 'a']++
        } else if (c in 'A'..'Z') {
            letters[c - 'A']++
        }
    }
    for (i in letters.lastIndex downTo 0) {
        if (letters[i] >= 2) return ('A' + i).toString()
    }
    return ""
}