package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(longestPalindrome("abccccdd"))
    println(longestPalindrome("aaa"))
    println(longestPalindrome("aaacccddd"))
    println(longestPalindrome("bananas"))
}

private fun longestPalindrome(s: String): Int {

    val letters = IntArray(52)
    for (c in s) {
        if (c in 'A'..'Z') {
            letters[c - 'A']++
        } else {
            letters[c - 'a' + 26]++
        }
    }
    var hasOdd = false
    var total = 0
    for (num in letters) {
        if (num % 2 == 0) {
            total += num
        } else {
            if (num != 1) {
                total += (num - 1)
            }
            hasOdd = true
        }
    }
    if (hasOdd) {
        total++
    }

    return total
}