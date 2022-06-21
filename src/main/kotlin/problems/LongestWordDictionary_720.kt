package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(longestWord(arrayOf("a", "banana", "app", "appl", "ap", "apply", "apple")))
    println(longestWord(arrayOf("w", "wo", "wor", "worl", "world")))
}

private fun longestWord(words: Array<String>): String {

    val set = words.toHashSet()
    var result = words.first()
    for (word in words) {
        var flag = true
        for (i in 1 until word.length) {
            val temp = word.substring(0, i)
            if (temp !in set) {
                flag = false
                break
            }
        }
        if (flag && word.length >= result.length) {
            if (word.length == result.length) {
                if (word < result) result = word
            } else {
                result = word
            }
        }
    }
    return result

}