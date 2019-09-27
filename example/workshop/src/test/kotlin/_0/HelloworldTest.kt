package _0

import org.junit.jupiter.api.Test

import assertk.assertThat
import assertk.assertions.isEqualTo

class HelloworldTest {

    @Test
    fun helloworld() {
        assertThat(sayHelloUpper("Talend")).isEqualTo("Hello TALEND")
        assertThat(sayHelloUpper("Casablanca")).isEqualTo("Hello CASABLANCA")
        arrayOf("val1", "val2", "val3").asSequence()
    }
}