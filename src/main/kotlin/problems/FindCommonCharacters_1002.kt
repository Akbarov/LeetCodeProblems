package problems

import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(commonChars(arrayOf("bella", "label", "roller")).joinToString())
    println(commonChars(arrayOf("cool","lock","cook")).joinToString())
}

private fun commonChars(words: Array<String>): List<String> {
    val letters = IntArray(26)
    for (c in words[0]) {
        letters[c - 'a']++
    }
    for (i in 1 until words.size) {
        val w = words[i]
        val temp = IntArray(26)
        for (c in w) {
            temp[c - 'a']++
        }
        for (l in letters.indices) {
            if (letters[l] != temp[l]) {
                letters[l] = min(letters[l],temp[l])
            }
        }
    }
    val list = mutableListOf<String>()
    for (index in letters.indices) {
        var temp = letters[index]
        while (temp-- > 0) {
            list.add(('a' + index).toString())
        }
    }
    return list
}