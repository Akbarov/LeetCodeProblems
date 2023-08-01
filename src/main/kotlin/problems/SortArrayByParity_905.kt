package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
        println(sortArrayByParity(intArrayOf(1,2,3,4,5,6)).joinToString())
}
private  fun sortArrayByParity(nums: IntArray): IntArray {

   return nums.sortedWith(Comparator { first , second -> first%2-second%2 }).toIntArray()

}