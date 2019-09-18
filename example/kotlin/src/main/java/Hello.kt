fun main(): Unit {
    val pony = Pony("Rainbow", 42)
    pony.friendsCount = pony.name.length

    println("hello $pony")
}

class Pony(val name: String,
           var friendsCount: Int = 0) {

    override fun toString(): String {
        return "$name $friendsCount"
    }
}