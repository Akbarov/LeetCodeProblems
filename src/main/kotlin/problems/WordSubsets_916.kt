package problems



/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(wordSubsets(arrayOf("amazon", "apple", "facebook", "google", "leetcode"), arrayOf("e", "o")))
}

private fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
    val secondArray = IntArray(26)
    for (w in words2) {
        val tempArray = IntArray(26)
        for (c in w) {
            tempArray[c - 'a']++
        }
        for (i in tempArray.indices) {
            secondArray[i] = secondArray[i].coerceAtLeast(tempArray[i])
        }
    }
    val result = mutableListOf<String>()
    for (w in words1) {
        val firstArray = IntArray(26)
        for (c in w) {
            firstArray[c - 'a']++
        }
        var contain = true
        for (i in secondArray.indices) {
            if (firstArray[i] < secondArray[i]) {
                contain = false
                break
            }
        }
        if (contain) result.add(w)
    }
    return result
}