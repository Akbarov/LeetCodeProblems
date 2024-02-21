package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(maximumElementAfterDecrementingAndRearranging(intArrayOf(2, 2, 2, 1, 1)))
}

private fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
    arr.sort()
    arr[0] = 1
    var count = 1
    for (i in 1 until arr.size) {
        if (arr[i] > arr[i - 1]) arr[i] = arr[i - 1] + 1
        else break
        count++
    }
    return count

}