package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun floodFill(
    image: Array<IntArray>,
    sr: Int,
    sc: Int,
    newColor: Int
): Array<IntArray> {
    helper(image, sr, sc, newColor, image[sr][sc])
    return image

}

private fun helper(image: Array<IntArray>, i: Int, j: Int, newColor: Int, oldColor: Int) {
    if (i < 0 || j < 0 || i >= image.size || j >= image[0].size || image[i][j] == newColor) return
    if (image[i][j] == oldColor) image[i][j] = newColor
    helper(image, i - 1, j, newColor, oldColor)
    helper(image, i + 1, j, newColor, oldColor)
    helper(image, i, j - 1, newColor, oldColor)
    helper(image, i, j + 1, newColor, oldColor)
}
