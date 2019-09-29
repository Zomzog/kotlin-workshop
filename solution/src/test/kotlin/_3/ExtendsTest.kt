package _3

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class ExtendsTest {
    @Test
    fun ponyToString() {
        assertThat(ponyToString(UntouchablePony("name", "type"))).isEqualTo("name - type")
        assertThat(ponyToString(UntouchablePony("Pinkie Pie", "Earth"))).isEqualTo("Pinkie Pie - Earth")
    }

    @Test
    fun stringToPony() {
        assertThat(stringToPony("name - type")).isEqualTo(UntouchablePony("name", "type"))
        assertThat(stringToPony("Pinkie Pie - Earth")).isEqualTo(UntouchablePony("Pinkie Pie", "Earth"))
    }
}