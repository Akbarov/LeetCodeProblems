package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(fib(1))
    println(fib(2))
    println(fib(3))
    println(fib(25))
}


private tailrec fun fib(n: Int, fib0: Int = 0, fib1: Int = 1): Int {
    return when (n) {
        0 -> fib0
        1 -> fib1
        else -> fib(n - 1, fib1, fib0 + fib1)
    }
}
