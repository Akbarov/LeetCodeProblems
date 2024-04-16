package uber

import kotlin.math.abs
import kotlin.math.min


fun main() {

}

private fun shortestDistance(wordsDict: Array<String>, word1: String, word2: String): Int {
    val list = mutableListOf<Int>()
    for ((index, item) in wordsDict.withIndex()) {
        if (item == word1) {
            list.add(index)
        }
    }
    var result = Int.MAX_VALUE
    for ((index, item) in wordsDict.withIndex()) {
        if (item == word2) {
            for (i in list) {
                result = min(abs(index-i),result)
            }
        }
    }
    return result
}