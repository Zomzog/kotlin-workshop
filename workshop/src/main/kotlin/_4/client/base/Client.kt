package _4.client.base

import com.github.kittinunf.fuel.httpGet
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import com.github.kittinunf.result.Result;
import java.lang.Exception

fun main() = threads()

// suspend fun main() = coroutines()

private fun threads() {
    repeat(10000) {
        val thread = Thread {
            callHello()
        }
        thread.start()
    }
}

private suspend fun coroutines() {
    coroutineScope {
        repeat(10000) {
            launch {
                callHello()
            }
            println("Hello")
        }
    }
}

private fun callHello() {
    "http://localhost:8080/hello".httpGet().responseString { request, response, result ->
        //do something with response
        when (result) {
            is Result.Failure -> {
                throw Exception("Failure !")
            }
            is Result.Success -> {
                println(result.get())
            }
        }
    }
}