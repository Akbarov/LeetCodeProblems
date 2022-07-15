package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private class Trie() {
    val words = mutableSetOf<String>()
    val searchWords = mutableSetOf<String>()
    fun insert(word: String) {
        words.add(word)
        val sb = StringBuilder()
        for (c in word) {
            sb.append(c)
            searchWords.add(sb.toString())
        }
    }

    fun search(word: String): Boolean {
        return words.contains(word)
    }

    fun startsWith(prefix: String): Boolean {
        return searchWords.contains(prefix)
    }

}