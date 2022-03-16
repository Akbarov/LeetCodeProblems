package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(fib(2))
println(fib(3))
println(fib(25))
}

private fun fib(n: Int): Int {
    return calFib(n,0,1)
}

private tailrec fun calFib(n: Int, fib1: Int, fib2: Int): Int {
    if (n == 0) return fib1
    if (n==1) return fib2
    return calFib(n - 1, fib2, fib2 + fib1)
}