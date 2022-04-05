package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(detectCapitalUse("USA"))
    println(detectCapitalUse("FlaG"))
    println(detectCapitalUse("FFFFFFFFf"))
}

private fun detectCapitalUse(word: String): Boolean {

    if (word.isBlank()) return false
    var upperCount = 0
    var lowerCount = 0
    for (c in word) {
        if (c.isUpperCase()) {
            upperCount++
        } else lowerCount++
    }
    if (upperCount == 0 || lowerCount == 0) return true
    if (upperCount == 1 && word.first().isUpperCase()) return true
    return false
}