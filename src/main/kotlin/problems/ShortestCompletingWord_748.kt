package problems

import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(shortestCompletingWord("1s3 PSt", arrayOf("step", "steps", "stripe", "stepple")))
}

private fun shortestCompletingWord(licensePlate: String, words: Array<String>): String {
    var result = ""
    var maxCount = 0
    val license = IntArray(26)
    for (c in licensePlate) {
        if (c in 'a'..'z') license[c - 'a']++
        else if (c in 'A'..'Z') license[c - 'A']++
    }
    for (word in words) {
        val tempArray = IntArray(26)
        for (c in word) {
            if (c in 'a'..'z') tempArray[c - 'a']++
        }
        var count = 0
        for (i in tempArray.indices) {
            count += min(tempArray[i], license[i])
        }
        if ((maxCount < count) || maxCount == count && result.length > word.length) {
            result = word
            maxCount = count
        }
    }
    return result

}