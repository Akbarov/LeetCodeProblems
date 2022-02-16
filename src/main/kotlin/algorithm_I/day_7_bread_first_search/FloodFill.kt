package algorithm_I.day_7_bread_first_search

fun main() {
    val matrix = floodFill(arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1)), 1, 1, 2)
    for (array in matrix) {
        println(array.joinToString())
    }
}

private fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
    fill(image, sr, sc, image[sr][sc], newColor)
    return image
}

private fun fill(
    image: Array<IntArray>,
    sr: Int,
    sc: Int,
    oldColor: Int,
    newColor: Int
) {

    if (sr < 0 || sc < 0 || sr >= image.size || sc >= image[0].size) {
        return
    }
    println("$sr: $sc")
    if (image[sr][sc] == newColor || image[sr][sc] != oldColor) {
        return
    } else {
        image[sr][sc] = newColor
    }
    fill(image, sr - 1, sc, oldColor, newColor);
    fill(image, sr, sc - 1, oldColor, newColor);
    fill(image, sr + 1, sc, oldColor, newColor);
    fill(image, sr, sc + 1, oldColor, newColor);
}