package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(brokenCalc(2, 3))
    println(brokenCalc(5, 14))
    println(brokenCalc(3, 10))
}

private fun brokenCalc(startValue: Int, target: Int): Int {
    if (startValue >= target) return startValue - target
    return if (target % 2 == 0) {
        brokenCalc(startValue, target / 2) + 1
    } else {
        brokenCalc(startValue, target + 1) + 1
    }
}

