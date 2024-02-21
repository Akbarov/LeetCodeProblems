package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    print(sortVowels("lEetcOde"))
}

private fun sortVowels(s: String): String {

    val charArray = s.toCharArray()
    val setVowels = setOf('a', 'e', 'u', 'i', 'o', 'A', 'E', 'U', 'I', 'O')
    val pq = PriorityQueue<Char>()

    for (i in charArray.indices) {
        if (charArray[i] in setVowels) {
            pq.offer(charArray[i])
        }
    }
    for (i in charArray.indices) {
        if (charArray[i] in setVowels) {
            charArray[i] = pq.poll()
        }
    }
    return charArray.toString()
}