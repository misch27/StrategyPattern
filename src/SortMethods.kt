import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.*
import kotlin.Comparator

interface SortStrategy {
    fun sortList(list: Array<Int>)

    val strategyName: String
}

class StandartSort: SortStrategy {
    override fun sortList(list: Array<Int>) {
        list.sort()
    }

    override val strategyName: String
        get() = "StandartSort"

}

class CustomUserSort: SortStrategy {
    private val comparator = Comparator { p1: Int, p2: Int ->
        when {
            (p1 > p2) -> 1
            (p1 < p2) -> -1
            else -> 0
        }
    }

    override fun sortList(list: Array<Int>) {
        list.sortWith(comparator)
    }

    override val strategyName: String
        get() = "CustomUserSort"

}

class SortMethods(var sortStrategy: SortStrategy) {
    fun sortWithStrategy(randomList: Array<Int>){
        val clonedArray = randomList.clone()
        val startTime = LocalDateTime.now()
        sortStrategy.sortList(clonedArray)
        val endTime = LocalDateTime.now()
        val interval = ChronoUnit.MILLIS.between(startTime, endTime)
        println("Sort ends with $interval millis. Method: ${sortStrategy.strategyName}")
    }
}