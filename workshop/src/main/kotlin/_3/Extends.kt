package _3

fun main() {

    val pony = UntouchablePony("Rainbow Dash", "Pegasi")

    println(ponyToString(pony))

    println(stringToPony("Pinkie Pie - Earth"))
}

// TODO must return UntouchablePony from "name - type"
fun stringToPony(s: String): UntouchablePony {
    TODO()
    // return s.toPony()
}

// TODO must return String "name - type"
fun ponyToString(pony: UntouchablePony): String {
    TODO()
    // return pony.toCustomString()
}
