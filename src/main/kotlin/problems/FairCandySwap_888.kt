package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(fairCandySwap(intArrayOf(1, 1), intArrayOf(2, 2)).joinToString())
}

private fun fairCandySwap(aliceSizes: IntArray, bobSizes: IntArray): IntArray {
    val aliceSum = aliceSizes.sum()
    val bobSum = bobSizes.sum()
    val average = (aliceSum + bobSum) / 2
    for (item in aliceSizes) {
        for (elem in bobSizes) {
            if (bobSum - elem + item == aliceSum + elem - item) {
                return intArrayOf(item, elem)
            }
        }
    }
    return IntArray(2)
}