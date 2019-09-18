package bzh.zomzog.kotlinworkshop.service

import bzh.zomzog.kotlinworkshop.domain.Pony
import bzh.zomzog.kotlinworkshop.domain.PonyType
import bzh.zomzog.kotlinworkshop.repository.PonyRepository
import bzh.zomzog.kotlinworkshop.repository.documents.PonyMongo
import bzh.zomzog.kotlinworkshop.repository.documents.PonyMongoBuilder
import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class PonyService(private val ponyRepository: PonyRepository,
                  private val mapper: PonyMapper) {

    fun list(): List<Pony> {
        val first = listOf("val1", "val2", "val3").asSequence()
                .map { it.toUpperCase() }
                .onEach { println(it) }
                .filter { it == "VAL2" }
                .first()

        TODO()
    }


    fun save(pony: Pony): Pony {
        TODO()
    }
}