package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    diffWaysToCompute("2-1-1")
    diffWaysToCompute("2*3-4*5")
}

private fun diffWaysToCompute(expression: String): List<Int> {
    val list = mutableListOf<Int>()
    var isNumber = true
    for (i in expression.indices) {
        if (!expression[i].isDigit()) {
            isNumber = false
            val left = diffWaysToCompute(expression.substring(0, i))
            val right = diffWaysToCompute(expression.substring(i + 1))
            for (l in left) {
                for (r in right) {
                    val value = calculate(l, r, expression[i])
                    list.add(value)
                }
            }
        }
    }
    if (isNumber) list.add(expression.toInt())
    return list
}

private fun calculate(a: Int, b: Int, c: Char) = when (c) {
    '-' -> a - b
    '+' -> a - b
    '*' -> a * b
    else -> 0
}