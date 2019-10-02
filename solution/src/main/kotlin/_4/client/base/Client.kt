package _4.client.base

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.coroutines.awaitStringResponseResult
import com.github.kittinunf.fuel.httpGet
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import com.github.kittinunf.result.Result;
import kotlinx.coroutines.runBlocking
import java.lang.Exception

//fun main() = threads()

 suspend fun main() = coroutines()

private fun threads() {
    repeat(10000) {
        val thread = Thread {
            callHello(it)
        }
        thread.start()
    }
}

private suspend fun coroutines() {
    coroutineScope {
        repeat(10000) {
            launch {
                callHelloCoroutine(it)
            }
        }
    }
}

private suspend fun callHelloCoroutine(i: Int) {
    val (request, response, result) = Fuel.get("http://localhost:8080/hello").awaitStringResponseResult()

    doSomething(result, i)
}

private fun callHello(i: Int) {
    val (request, response, result) = Fuel.get("http://localhost:8080/hello").responseString()

    doSomething(result, i)
}


private fun doSomething(result: Result<String, FuelError>, i: Int) {
    result.fold(
            { data -> println("$data - ${Thread.currentThread().name} - $i") },
            { error ->
                run {
                    println("An error of type ${error.exception} happened: ${error.message}")
                    throw Exception("Stop it")
                }
            }
    )
}
