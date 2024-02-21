package problems

import java.util.*

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private class FoodRatings(val foods: Array<String>, val cuisines: Array<String>, val ratings: IntArray) {

    val cuisineMap = mutableMapOf<String, PriorityQueue<Combo>>()
    val foodMap = mutableMapOf<String, Combo>()

    init {
        for (i in foods.indices) {
            val combo = Combo(food = foods[i], cuisine = cuisines[i], ratings[i])
            foodMap[foods[i]] = combo
            if (cuisineMap.containsKey(cuisines[i])) {
                cuisineMap[cuisines[i]]?.add(combo)
            } else {
                val pq = PriorityQueue<Combo> { o1, o2 ->
                    if (o1.rating == o2.rating) o1.food.compareTo(o2.food)
                    else o2.rating.compareTo(o1.rating)
                }
                pq.add(combo)
                cuisineMap[cuisines[i]] = pq
            }
        }
    }

    fun changeRating(food: String, newRating: Int) {
        val prev = foodMap[food] ?: return
        val newCombo = Combo(food, prev.cuisine, newRating)
        foodMap[food] = newCombo
        cuisineMap[prev.cuisine]?.add(newCombo)
        prev.food = ""
    }

    fun highestRated(cuisine: String): String {
        while (cuisineMap[cuisine]?.peek()?.food.isNullOrBlank()) {
            cuisineMap[cuisine]?.poll()
        }
        return cuisineMap[cuisine]?.poll()?.food?:""
    }

}

private class Combo(var food: String, val cuisine: String, val rating: Int)