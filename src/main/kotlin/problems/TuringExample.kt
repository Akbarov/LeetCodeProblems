package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(evaluate(listOf("5", "2", "C", "D", "+")))
    println(evaluate(listOf("5", "-2","4", "C", "D", "9","+","+")))
}

private fun evaluate(list: List<String>): Int {
    val result = mutableListOf<Int>()
    for (item in list) {
        when (item) {
            "+" -> {
                result.add((result[result.size - 2] + result[result.size - 1]))
            }
            "D" -> {
                result.add(result[result.size - 1] * 2)
            }
            "C" -> {
                result.removeLast()
            }
            else -> {
                result.add(item.toInt())
            }
        }
    }
    var value = 0
    for (item in result) {
        value += item
    }
    return value
}