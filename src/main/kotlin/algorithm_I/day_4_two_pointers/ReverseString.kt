package algorithm_I.day_4_two_pointers

fun main() {
    reverseString(charArrayOf('H', 'e', 'l', 'l', 'o'))
}

private fun reverseString(s: CharArray) {
    s.reverse()
    println(s.joinToString())
}