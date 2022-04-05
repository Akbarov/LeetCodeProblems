package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(capitalizeTitle("capiTalIze tHe titLe"))
}

private fun capitalizeTitle(title: String): String {

    return title.split(" ").joinToString(" ") {
        if (it.length > 2) {
            it.lowercase(Locale.getDefault()).replaceFirstChar(Char::uppercase)
        } else {
            it.lowercase()
        }
    }
}