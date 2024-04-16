package problems

fun main() {

}

private fun findMinArrowShots(points: Array<IntArray>): Int {
    points.sortBy { it[0] }
    val last = intArrayOf(points[0][0], points[0][1])
    var i =1
    var result =0
    while (i < points.size) {
        if (last.last()>=points[i].first()){
            last[1] = minOf(last.last(),points[i].last())
        }else{
            last[0] = points[i][0]
            last[1] = points[i][1]
            result++
        }
        i++
    }
    return result
}