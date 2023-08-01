package problems

import java.util.*


/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(getOrder(arrayOf(intArrayOf(1, 2), intArrayOf(2, 4), intArrayOf(3, 2), intArrayOf(4, 1))).joinToString())
}

fun getOrder(tasks: Array<IntArray>): IntArray {
    val processingTimeThenIndex = Comparator
        .comparing { obj: Task -> obj.processingTime }
        .thenComparing { obj: Task -> obj.index }
    val allTasks: Queue<Task> = PriorityQueue(
        Comparator.comparingInt { obj: Task -> obj.enqueueTime }.thenComparing(processingTimeThenIndex)
    )
    val availableTasks: Queue<Task> = PriorityQueue(processingTimeThenIndex)
    var i = 0
    val tasksLength = tasks.size
    while (i < tasksLength) {
        val taskInfo = tasks[i]
        val task = Task(taskInfo[0], taskInfo[1], i)
        allTasks.offer(task)
        i++
    }
    var virtualTime = 0
    var orderCounter = 0
    val order = IntArray(tasks.size)
    while (!allTasks.isEmpty() || !availableTasks.isEmpty()) {
        val nextTask: Task
        if (availableTasks.isEmpty()) {
            nextTask = allTasks.poll()
            virtualTime = nextTask.enqueueTime
        } else {
            nextTask = availableTasks.poll()
        }
        order[orderCounter++] = nextTask.index
        virtualTime += nextTask.processingTime
        while (!allTasks.isEmpty() && allTasks.peek().enqueueTime <= virtualTime) {
            availableTasks.offer(allTasks.poll())
        }
    }
    return order
}


data class Task(
    val enqueueTime: Int,
    val processingTime: Int,
    val index: Int
)

