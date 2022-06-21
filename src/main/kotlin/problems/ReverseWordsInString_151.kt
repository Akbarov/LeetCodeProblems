package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(reverseWords("   Hello    world"))
}

private fun reverseWords(s: String): String {
    return s.split(" ").filter { it.isNotBlank() }.reversed().joinToString(" ")
}