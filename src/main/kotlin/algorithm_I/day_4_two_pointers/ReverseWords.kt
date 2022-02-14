package algorithm_I.day_4_two_pointers

fun main() {
println(reverseWords("Hello I'm a programmist"))
}

private fun reverseWords(s: String): String {
    if (s.isBlank()) return s
    val list = s.split(" ")

    val builder = StringBuilder(list.first().reversed())
    for (i in 1..list.lastIndex) {
        builder.append(" ${list[i].reversed()}")
    }
    return builder.toString()
}