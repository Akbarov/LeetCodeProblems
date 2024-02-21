package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(backspaceCompare("ab#c", "ad#c"))
}

private fun backspaceCompare(s: String, t: String): Boolean {
    return editor(s) == editor(t)
}

private fun editor(s: String): String {
    var count = 0
    val sb = StringBuilder()
    for (i in s.lastIndex downTo 0) {
        if (s[i] == '#') count++
        else if (count > 0) count--
        else sb.append(s[i])
    }
    return sb.toString()
}