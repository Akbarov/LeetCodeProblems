package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(replaceWords(listOf("cat", "pat"), "the pattern is very good the cater"))
}

private fun replaceWords(dictionary: List<String>, sentence: String): String {
    val sortedList = dictionary.sortedBy { it.length }
    val words = sentence.split(" ").filter { it.isNotBlank() }.toMutableList()
    for ((index, w) in words.withIndex()) {
        for (item in sortedList) {
            if (w.startsWith(item)) {
                words[index] = item
                break
            }
        }
    }
    return words.joinToString(" ")
}