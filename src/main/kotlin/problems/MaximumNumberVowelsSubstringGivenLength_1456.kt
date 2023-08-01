package problems

import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(maxVowels("alisher",3))
}

private fun maxVowels(s: String, k: Int): Int {
    val vowels = setOf('a', 'u', 'e', 'i', 'o')
    var result = s.substring(0, k).count { it in vowels }
    var temp = result
    var right = k
    var left = 0
    while (left < s.length - k && right < s.length) {
        if (s[right] in vowels) temp++
        if (s[left] in vowels) temp--
        right++
        left++
        result = max(result, temp)
    }
    return result
}