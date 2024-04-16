package problems

fun main() {

}

private fun getWinner(arr: IntArray, k: Int): Int {
    val temp = if (k > arr.size) arr.size - 1 else k
    for (i in arr.indices) {
        if (i == 0) {
            var index = 1
            while (index <= temp && arr[0] > arr[index]) {
                index++
            }
            if (index == temp) return arr[0]
        } else {
            if (arr[i] > arr[i - 1]) {
                var index = i + 1
                while ((index - i) <= temp && arr[i] > arr[index % arr.size]) {
                    index++
                }
                if (index == temp) return arr[0]
            }
        }
    }
    return -1
}