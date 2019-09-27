package _3

fun main() {

    val pony = UntouchablePony("Rainbow Dash", "Pegasi")

    println(ponyToString(pony))

    println(stringToPony("Pinkie Pie - Earth"))
}

// TODO must return UntouchablePony from "name - type"
fun stringToPony(s: String): UntouchablePony {
    return s.toPony()
}

// TODO must return String "name - type"
fun ponyToString(pony: UntouchablePony): String {
    return pony.toCustomString()
}

private fun String.toPony(): UntouchablePony {
    val (name, type) = this.split(" - ")
    return UntouchablePony(name, type)
}

private fun UntouchablePony.toCustomString(): String {
    return "$name - $type"
}
