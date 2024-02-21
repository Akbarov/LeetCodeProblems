package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(findInMountainArray(0, intArrayOf(0, 5, 3, 1)))
    println(findInMountainArray(3, intArrayOf(0, 1, 2, 4, 2, 1)))
}

private fun findInMountainArray(target: Int, mountainArr: IntArray): Int {
    val pickValue = findMountainIndex(mountainArr)
    if (pickValue == -1) return -1
    var left = 0
    var right = pickValue
    while (left <= right) {
        val mid = (left + right) / 2
        if (mountainArr.get(mid) == target) return mid
        else if (mountainArr.get(mid) > target) right = mid - 1
        else left = mid + 1
    }
    left = pickValue
    right = mountainArr.size - 1
    while (left <= right) {
        val mid = (left + right) / 2
        if (mountainArr.get(mid) == target) return mid
        else if (mountainArr.get(mid) > target) left = mid + 1
        else right = mid - 1
    }
    return -1
}


private fun findMountainIndex(mountainArr: IntArray): Int {
    var left = 0
    var right = mountainArr.size
    while (left < right) {
        val mid = (left + right) / 2
        val midValue = mountainArr.get(mid)
        if (mid == 0) {
            left++
            continue
        }
        if (mid == mountainArr.size) {
            right--
            continue
        }


        if (mountainArr.get(mid - 1) < midValue && midValue > mountainArr.get(mid + 1)) {
            return mid
        } else if (mountainArr.get(mid - 1) < midValue && midValue < mountainArr.get(mid + 1)) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return left
}
