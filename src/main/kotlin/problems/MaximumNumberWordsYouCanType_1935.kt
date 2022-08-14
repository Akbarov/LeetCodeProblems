package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun canBeTypedWords(text: String, brokenLetters: String): Int {
    if (text.isEmpty()) return 0
    val words = text.split(" ")
    val set = brokenLetters.toHashSet()
    var count = 0
    words.forEach { w ->
        var flag = true
        for (c in w)
            if (c in set) {
                flag = false
                break
            }
        if (flag) count++
    }
    return count
}