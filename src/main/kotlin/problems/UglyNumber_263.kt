package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(isUgly(6))
println(isUgly(1))
println(isUgly(14))
}

private fun isUgly(n: Int): Boolean {
    if (n == 1) return true
    var number = n
    var flag: Boolean
    do {
        flag = false
        if (number % 2 == 0) {
            number /= 2
            flag = true
        }
        if (number % 3 == 0) {
            number /= 3
            flag = true
        }
        if (number % 5 == 0) {
            number /= 5
            flag = true
        }
    } while (number > 1 && flag)
    return number == 1
}