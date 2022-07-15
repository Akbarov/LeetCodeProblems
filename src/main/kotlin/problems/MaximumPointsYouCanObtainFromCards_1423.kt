package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(maxScore(intArrayOf(2, 2, 2), 2))
    println(maxScore(intArrayOf(1,2,3,4,5,6,1), 3))
}

private fun maxScore(cardPoints: IntArray, k: Int): Int {
    if (cardPoints.size == k) return cardPoints.sum()
    var dif = cardPoints.size - k
    var minValue = Int.MAX_VALUE
    var sum = 0
    var left = 0
    var right = 0
    while (right < cardPoints.size) {
        sum += cardPoints[right++]
        if (right - left > dif) {
            sum -= cardPoints[left++]
        }
        if (right - left == dif) {
            if (minValue > sum) minValue = sum
        }
    }
    return cardPoints.sum() - minValue
}