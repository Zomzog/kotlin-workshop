package _99

data class Workshop(val name: String, var attendeesCount: Long)

fun helloWorkshop(workshop: Workshop): String {
    val (name, count) = workshop;
    return "Hello to ${workshop.attendeesCount} attendees of ${workshop.name} workshop"
}

fun main() {
    val workshop = Workshop("Kotlin", 42)
    println(helloWorkshop(workshop))
}