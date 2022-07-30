package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {

    var count = 0
    for (i in flowerbed.indices) {
        if (flowerbed[i] == 0) {
            if (i > 0 && flowerbed[i - 1] == 1) continue
            if (i < flowerbed.size - 1 && flowerbed[i + 1] == 1) continue
            flowerbed[i] = 1
            count++
        }
    }
    return count >= n
}