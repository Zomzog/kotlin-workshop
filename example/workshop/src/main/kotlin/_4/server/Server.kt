package _4.server

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.coroutines.delay
import java.time.OffsetDateTime
import java.util.concurrent.atomic.AtomicInteger


fun main(args: Array<String>) {

    val count = AtomicInteger()

    val server = embeddedServer(Netty, 8080) {
        routing {
            get("/hello") {
                delay(1000)
                call.respondText("Hello, Talend! It's ${OffsetDateTime.now()}", ContentType.Text.Html)
            }
            get("/failEvery10") {
                val current = count.incrementAndGet();
                if (current.rem(10) == 0) {
                    println("Fail")
                    throw Exception("fail !")
                } else {
                    delay(1000)
                    call.respondText("Hello, Talend! It's ${OffsetDateTime.now()}", ContentType.Text.Html)
                }
            }
        }
    }
    server.start(wait = true)
}