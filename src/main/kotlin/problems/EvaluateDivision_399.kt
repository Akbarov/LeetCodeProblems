package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {

    val result = DoubleArray(queries.size) { -1.0 }
    val map = mutableMapOf<String, Double>()

    for (i in equations.indices) {
        val equ = equations[i]
        map[equ.first()] = values[i] * equ.last().hashCode()
        map[equ.last()] = equ.first().hashCode() / values[i]
    }
    for (i in queries.indices) {
        val equ = queries[i]
        val first = map[equ.first()]
        val second = map[equ.last()]
        if (first != null && second != null) {
            result[i] = first / second
        }
    }
    return result
}