package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(uniqueMorseRepresentations(arrayOf("gin","zen","gig","msg")))
}

private fun uniqueMorseRepresentations(words: Array<String>): Int {
    val letters = arrayOf(
        ".-",
        "-...",
        "-.-.",
        "-..",
        ".",
        "..-.",
        "--.",
        "....",
        "..",
        ".---",
        "-.-",
        ".-..",
        "--",
        "-.",
        "---",
        ".--.",
        "--.-",
        ".-.",
        "...",
        "-",
        "..-",
        "...-",
        ".--",
        "-..-",
        "-.--",
        "--.."
    )
    val set = mutableSetOf<String>()
    for (w in words) {
        val sb = StringBuilder()
        for (c in w) {
            sb.append(letters[c - 'a'])
        }
        set.add(sb.toString())
    }

    return set.size
}