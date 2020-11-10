import java.util.*

fun getRandomIntArray(): Array<Int> {
    val ran = Random()
    return IntArray(900000) { ran.nextInt() }.toTypedArray()
}

fun main(args: Array<String>) {
    val sortMethodsArray = arrayListOf(
        SortMethods(StandartSort()),
        SortMethods(CustomUserSort()),
        SortMethods(JavaCodeSort())
    )

    val randomArray  = getRandomIntArray()

    sortMethodsArray.forEach{
        it.sortWithStrategy(randomArray)
    }

}