package bzh.zomzog.kotlinworkshop.service

import bzh.zomzog.kotlinworkshop.domain.PonyType.Earth
import bzh.zomzog.kotlinworkshop.repository.PonyRepository
import bzh.zomzog.kotlinworkshop.repository.documents.PonyMongo
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.bson.types.ObjectId
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDateTime
import java.util.*

internal class PonyServiceSaveTest {

    private val repository = mockk<PonyRepository>()

    private val mapper = PonyMapper()
    private val service = PonyService(repository, mapper)

    @Test
    fun `create a new pony`() {
        val newOne = ponyDefault(id = null, createdAt = null)
        every { repository.save(ofType(PonyMongo::class)) } returns ponyMongoDefault()

        val result = service.save(newOne)

        assertThat(result).isEqualTo(ponyDefault())
    }


    @Test
    fun `Update one get from DB`() {
        val update = ponyDefault(type = Earth)
        every { repository.findById(ObjectId(update.id)) } returns Optional.of(ponyMongoDefault())
        every { repository.save(ponyMongoDefault(type = Earth)) } returns ponyMongoDefault(type = Earth)

        val result = service.save(update)

        assertThat(result).isEqualTo(ponyDefault(type = Earth))
    }

    @Test
    fun `Update do not change createdAt value`() {
        val update = ponyDefault(type = Earth, createdAt = LocalDateTime.MIN)
        every { repository.findById(ObjectId(update.id)) } returns Optional.of(ponyMongoDefault())
        every { repository.save(ponyMongoDefault(type = Earth)) } returns ponyMongoDefault(type = Earth)

        val result = service.save(update)

        assertThat(result).isEqualTo(ponyDefault(type = Earth))
    }

    @Test
    fun `Update not found`() {
        val update = ponyDefault()
        every { repository.findById(ObjectId(update.id)) } returns Optional.empty()

        assertThrows<RuntimeException> { service.save(update) }
    }
}