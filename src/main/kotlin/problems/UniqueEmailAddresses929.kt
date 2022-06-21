package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(
        numUniqueEmails(
            arrayOf(
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
            )
        )
    )
}

private fun numUniqueEmails(emails: Array<String>): Int {
    val set = mutableSetOf<String>()
    for (mail in emails) {
        val twoPart = mail.split('@')
        val temp = twoPart.first().replace(".", "").takeWhile { it!='+' }
        set.add(temp +"@"+ twoPart.last())
    }
    return set.size
}