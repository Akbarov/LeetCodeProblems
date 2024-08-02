package problems


fun main() {

}

private fun countOfPairs(n: Int, x: Int, y: Int): IntArray {
    val result = IntArray(n)
    if (x == y) {
        for (i in 0 until n) {
            result[i] = (n - 1 - i) * 2
        }
        return result
    }
    val graph = Array<MutableSet<Int>>(n) { mutableSetOf() }
    for (i in 0 until n) {
        when (i) {
            0 -> graph[0].add(1)
            n - 1 -> graph[i].add(i - 1)
            else -> graph[i].addAll(setOf(i - 1, i + 1))
        }
    }
    graph[x].add(y)
    graph[y].add(x)

    return result
}