package problems

fun main() {
    println(compareVersion("1.01", "1.001"))
    println(compareVersion("1.01", "1"))
    println(compareVersion("0.1", "1.1"))
    println(compareVersion("1.0.0", "1"))
    println(compareVersion("1.10", "1.1"))
}

private fun compareVersion(version1: String, version2: String): Int {
    var f = 0
    var s = 0
    var num1 = 0
    var num2 = 0

    while (f < version1.length || s < version2.length) {
        while (f < version1.length && version1[f] != '.') {
            num1 = num1 * 10 + (version1[f] - '0')
            f++
        }
        while (s < version2.length && version2[s] != '.') {
            num2 = num2 * 10 + (version2[s] - '0')
            s++
        }
        if (num1 > num2) {
            return 1
        }
        if (num1 < num2) {
            return -1
        }
        num1 = 0
        num2 = 0
        f++
        s++
    }

    return 0
}