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

    fun list() = ponyRepository.findAll()
            .map { mapper.map(it) }


    fun save(pony: Pony): Pony {
        val updated = if (null == pony.id) {
            ponyRepository.save(pony.toNewPonyMongo())
        } else {
            val fromDb = ponyRepository.findById(ObjectId(pony.id))
            fromDb.map { mapper.update(it, pony) }
                    .orElseThrow { RuntimeException("Pony not found") } // TODO Named exception
        }
        Pony(name="name", type = PonyType.Pegasi)
        return mapper.map(updated)
    }

    fun Pony.toNewPonyMongo(): PonyMongo {
        return PonyMongoBuilder.newBuilder()
                .name(this.name)
                .type(this.type)
                .createdAt(LocalDateTime.now())
                .build()
    }
}