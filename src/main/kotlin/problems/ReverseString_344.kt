package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    reverseString(charArrayOf('h', 'e', 'l', 'l', 'o'))
    

}

private fun reverseString(s: CharArray) {
    val mid = s.size / 2 - 1
    if (mid < 0) return
    var counter = 0
    while (mid >= counter) {
        val temp = s[counter]
        s[counter] = s[s.lastIndex - counter]
        s[s.lastIndex - counter] = temp
        counter++
    }
    println(s.joinToString())
}