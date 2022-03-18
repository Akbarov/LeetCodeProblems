package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(4 ushr 1)
    println(scoreOfParentheses("()"))
    println(scoreOfParentheses("((()))"))
}

private fun scoreOfParentheses(s: String): Int {
    var score = 0
    var depth = 0
    var prev = '('
    for (c in s) {
        if (c == '(') {
            depth++
        } else {
            depth--
            if (prev == '(') {
                score += 1 shl depth
            }
        }
        prev = c
    }
    return score
}