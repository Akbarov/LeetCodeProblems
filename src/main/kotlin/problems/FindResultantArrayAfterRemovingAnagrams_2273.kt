package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun removeAnagrams(words: Array<String>): List<String> {
    val result = mutableListOf<String>()
    for (i in words.indices) {
        if (words[i] == "*") continue
        result.add(words[i])
        val sorted = words[i].toCharArray().sorted().joinToString("")
        for (j in i + 1 until words.size) {
            if (sorted == words[j].toCharArray().sorted().joinToString("")) {
                words[i] = "*"
            }
        }
    }
    return result
}