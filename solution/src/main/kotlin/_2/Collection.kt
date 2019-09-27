package _2

fun main() {
    val list = listOf("1", "2", "3")

    println(sum(list))

    val findFirst = listOf("1", "2", "010", "NaN")

    println(findFirst10(findFirst))
}

// TODO input is a list of Integer as String, return the some of them
fun sum(list: List<String>): Int {
    // TODO
    return list.map { it.toInt() }
            .toIntArray()
            .sum()
}

// TODO find the first string equals to 10
fun findFirst10(list: List<String>): Int {
    return list.asSequence()
            .map { it.toInt() }
            .first{ it == 10 }
}