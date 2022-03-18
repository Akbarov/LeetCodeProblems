package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun peakIndexInMountainArray(arr: IntArray): Int {
    for (i in 0 until arr.lastIndex) {
        if (arr[i] > arr[i + 1]) {
            return i
        }
    }
    return -1
}

private fun peakIndexInMountainArray2(arr: IntArray): Int {

    var left = 0
    var right = arr.lastIndex
    while (left < right) {
        val mid = (left + right) / 2
        if (arr[mid] > arr[mid + 1]) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left

}