package problems


/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(numberOfArithmeticSlices(intArrayOf(7, 7, 7, 7, 7)))
}


private  fun numberOfArithmeticSlices(A: IntArray): Int {
    val n = A.size
    var ans: Long = 0
    val cnt: Array<MutableMap<Int, Int>> = Array(n){ (mutableMapOf())}
    for (i in 0 until n) {
        cnt[i] = HashMap(i)
        for (j in 0 until i) {
            val delta = A[i].toLong() - A[j].toLong()
            if (delta < Int.MIN_VALUE || delta > Int.MAX_VALUE) {
                continue
            }
            val diff = delta.toInt()
            val sum = cnt[j].getOrDefault(diff, 0)
            val origin = cnt[i].getOrDefault(diff, 0)
            cnt[i][diff] = origin + sum + 1
            ans += sum.toLong()
        }
    }
    return ans.toInt()
}

