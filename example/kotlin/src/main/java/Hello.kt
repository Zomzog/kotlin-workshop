fun main() {
    val pony = Pony("Rainbow", 42)
    pony.friendsCount = pony.name.length

    println("hello $pony")
}

class Pony(val name: String,
           var friendsCount: Int = 0) {


}