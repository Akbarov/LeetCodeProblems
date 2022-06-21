package contest

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(strongPasswordCheckerII("IloveLe3tcode!"))
}

private fun strongPasswordCheckerII(password: String): Boolean {
    if (password.length < 8) return false
    if (!password.any { it in 'a'..'z' }) return false
    if (!password.any { it in 'A'..'Z' }) return false
    if (!password.any { it in '0'..'9' }) return false
    if (!password.any { it in "!@#\$%^&*()-+" }) return false
    for (i in 1 until password.length) {
        if (password[i] == password[i - 1]) return false
    }
    return true
}