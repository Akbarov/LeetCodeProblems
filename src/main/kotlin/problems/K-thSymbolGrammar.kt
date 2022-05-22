package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(kthGrammar(5, 5))
}

private fun kthGrammar(n: Int, k: Int): Int {
    if (n <= 0 || k <= 1) return 0
    var sb = "0"
    for (i in 1 until n) {
        val temp = StringBuilder()
        for (c in sb) {
            if (c == '0') {
                temp.append("01")
            } else {
                temp.append("10")
            }
        }
        sb = temp.toString()
    }

    return sb[k - 1] - '0'
}

private fun kthGrammar2(n: Int, k: Int): Int {
    if (n == 1) return 0
    return if (k % 2 == 0) {
        val kth = kthGrammar2(n - 1, k / 2)
        if (kth == 0) 1 else 0
    } else {
        val kth = kthGrammar2(n - 1, k / 2)
        if (kth == 0) 0 else 1
    }
}