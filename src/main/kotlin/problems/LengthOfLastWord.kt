package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(lengthOfTheLastWord("Hello world"))
println(lengthOfTheLastWord("   fly me   to   the moon  "))
println(lengthOfTheLastWord("luffy is still joyboy"))
}

private fun lengthOfTheLastWord(s: String): Int {
    var isChar = false
    var count = 0
    for (i in s.lastIndex downTo 0) {
        if (!s[i].isWhitespace()) {
            count++
            isChar = true
        } else {
            if (isChar) {
                return count
            }
        }
    }
    return count
}