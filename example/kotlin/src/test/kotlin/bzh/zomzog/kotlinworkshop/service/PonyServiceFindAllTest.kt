package bzh.zomzog.kotlinworkshop.service

import bzh.zomzog.kotlinworkshop.repository.PonyRepository
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PonyServiceFindAllTest {

    private val repository = mockk<PonyRepository>()

    private val mapper = PonyMapper()
    private val service = PonyService(repository, mapper)

    @Test
    fun `empty list`() {
        every { repository.findAll() } returns emptyList()

        val result = service.list()

        assertThat(result).isEmpty()
    }

    @Test
    fun `two pony mapped`() {
        val pony1 = ponyMongoDefault()
        val pony2 = ponyMongoDefault("5d8293800dbdf8463e65de91", "ponyB")
        every { repository.findAll() } returns listOf(pony1, pony2)

        val result = service.list()

        assertThat(result).containsExactlyInAnyOrder(mapper.map(pony1), mapper.map(pony2))
    }
}