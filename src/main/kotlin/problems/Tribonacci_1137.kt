package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(tribonacci(25))
}
private tailrec fun tribonacci(n: Int,t1:Int = 0,t2:Int = 1,t3:Int = 1): Int {
    if(n==0) return t1
    if(n==1) return t2
    if(n==2) return t3
    return tribonacci(n-1,t2,t3,t3+t2+t1)
}