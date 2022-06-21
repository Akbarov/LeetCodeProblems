package contest1

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(
        calculateTax(
            arrayOf(
            intArrayOf(3,50),
            intArrayOf(7,10),
            intArrayOf(12,25),
            ), 10
        )
    )
}

private fun calculateTax(brackets: Array<IntArray>, income: Int): Double {
    if (income == 0) return 0.0
    var temp = income
    var tax = if (brackets[0][0] < income) {
        temp -= brackets[0][0]
        (brackets[0][0]) * brackets[0][1] / 100.0
    } else {
        temp = 0
        income * brackets[0][1] / 100.0
    }
    var coun = 1
    while (temp > 0 && coun < brackets.size) {
        val diff = brackets[coun][0] - brackets[coun - 1][0]
        if (temp > diff) {
            tax += diff * brackets[coun][1] / 100.0
        } else {
            tax += temp * brackets[coun][1] / 100.0
        }
        temp -= diff
        coun++
    }
    return tax
}