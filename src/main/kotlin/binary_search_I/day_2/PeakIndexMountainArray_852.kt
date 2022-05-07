package binary_search_I.day_2

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(peakIndexInMountainArray(intArrayOf(0,1,0)))
println(peakIndexInMountainArray(intArrayOf(3,5,3,2,0)))
}

private fun peakIndexInMountainArray1(arr: IntArray): Int {
    if (arr.size < 3) return -1
    var pick = 0
    while (pick < arr.size && arr[pick] < arr[pick + 1]) {
        pick++
    }
    return pick
}

private fun peakIndexInMountainArray(arr: IntArray, left: Int = 0, right: Int = arr.lastIndex): Int {
    if (arr.size < 3) return -1
    val mid = (left + right) / 2
    return if (arr[mid - 1] < arr[mid]) {
        if (arr[mid] > arr[mid + 1]) {
            mid
        } else {
            peakIndexInMountainArray(arr, mid + 1, right)
        }
    } else {
        peakIndexInMountainArray(arr, left, mid )
    }

}