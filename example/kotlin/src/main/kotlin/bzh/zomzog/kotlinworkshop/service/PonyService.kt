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
            .map { it.toPony() }

    fun save(pony: Pony): Pony {
        val updated = if (null == pony.id) {
//            ponyRepository.save(pony.toNewPonyMongo())
            mapper.mapNew(pony)
        } else {
            ponyRepository.findById(ObjectId(pony.id))
                    .map { mapper.update(it, pony) }
                    .orElseThrow { RuntimeException("Pony not found") } // TODO Named exception
        }
        val result = ponyRepository.save(updated)
        return mapper.map(result)
    }

    fun PonyMongo.toPony() = Pony(this.id.toString(), this.name, this.type, this.createdAt)
}