package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(findOcurrences("we will we will find", "we", "will"))
}

private fun findOcurrences(text: String, first: String, second: String): Array<String> {
    val result = mutableListOf<String>()
    val list = text.split(" ")
    for (i in 1 until list.lastIndex) {
        if (list[i - 1] == first && list[i] == second) result.add(list[i + 1])
    }
    return result.toTypedArray()
}