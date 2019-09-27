package _2

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class CollectionTest {

    @Test
    fun `sum of one element`() {
        val list = listOf("1")

        val result = sum(list)

        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `sum with negative values`() {
        val list = listOf("1", "-1", "5", "-5")

        val result = sum(list)

        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `find first equals to 10`() {
        val list = listOf("0", "9", "-10", "10", "ten")

        val result = findFirst10(list)

        assertThat(result).isEqualTo(10)
    }
}