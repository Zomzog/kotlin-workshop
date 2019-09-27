package _4.client.error

import com.github.kittinunf.fuel.Fuel.get
import com.github.kittinunf.fuel.coroutines.awaitStringResponse
import com.github.kittinunf.fuel.coroutines.awaitStringResponseResult
import com.github.kittinunf.result.Result
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    try {
        threads()
    } catch (e: Exception) {
        println("${e.message} ok wait for others ?")
        Thread.sleep(3000)
    }
}

private fun threads() {
    val threads = mutableListOf<Thread>()
    repeat(20) {
        val thread = Thread {
            runBlocking {
                callFailEvery10()
            }
        }
        thread.start()
    }
    threads.forEach { it.join() }
}

private suspend fun coroutines() {
    TODO()
}

private suspend fun callFailEvery10() {
    val (request, response, result) = get("http://localhost:8080/failEvery10").awaitStringResponseResult()

    result.fold(
            { data -> println(data) /* "{"origin":"127.0.0.1"}" */ },
            { error ->
                run {
                    println("An error of type ${error.exception} happened: ${error.message}")
                    throw Exception("Stop it")
                }
            }
    )

}