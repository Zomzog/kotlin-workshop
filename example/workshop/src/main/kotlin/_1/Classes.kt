package _1

// /!\ Delete Workshop.java file /!\

// TODO workshop class with final name and variable attendeesCount
// data class Workshop(val name: String, var attendeesCount: Long)
// for Workshop("Kotlin", 42) return ""Hello to 42 attendees of Kotlin workshop"
fun helloWorkshop(workshop: Workshop): String {
    // TODO
    return "Hello to ${workshop.attendeesCount} attendees of ${workshop.name} workshop"
}

fun main() {
    val workshop = Workshop("Kotlin", 42)
    println(helloWorkshop(workshop))
}